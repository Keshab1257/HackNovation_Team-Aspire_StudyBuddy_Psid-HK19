document.addEventListener('DOMContentLoaded', () => {

    // ==========================
    // Navigation Elements
    // ==========================
    const landing = document.getElementById('landing');
    const learnHome = document.getElementById('learn-home');
    const askSection = document.getElementById('ask-section');
    const getQuestionsSection = document.getElementById('get-questions-section');
    const contributeSection = document.getElementById('contribute-section');

    const btnGoLearn = document.getElementById('go-learn');
    const btnGoContribute = document.getElementById('go-contribute');
    const btnBackToLanding = document.getElementById('back-to-landing');
    const btnBackToLandingFromContrib = document.getElementById('back-to-landing-from-contrib');
    const btnGoAsk = document.getElementById('go-ask');
    const btnGoGetQuestions = document.getElementById('go-get-questions');
    const btnBackToLearn = document.getElementById('back-to-learn');
    const btnBackToLearnFromGet = document.getElementById('back-to-learn-from-get');

    const showSection = (section) => {
        document.querySelectorAll('.section').forEach(s => s.classList.add('hidden'));
        section.classList.remove('hidden');
    };

    btnGoLearn?.addEventListener('click', () => showSection(learnHome));
    btnGoContribute?.addEventListener('click', () => showSection(contributeSection));
    btnBackToLanding?.addEventListener('click', () => showSection(landing));
    btnBackToLandingFromContrib?.addEventListener('click', () => showSection(landing));
    btnGoAsk?.addEventListener('click', () => showSection(askSection));
    btnGoGetQuestions?.addEventListener('click', () => showSection(getQuestionsSection));
    btnBackToLearn?.addEventListener('click', () => showSection(learnHome));
    btnBackToLearnFromGet?.addEventListener('click', () => showSection(learnHome));

    // ==========================
    // API Base URL (FIXED)
    // ==========================
    const API_URL = '/api';

    let metadataHierarchy = {};

    // ==========================
    // Fetch Metadata
    // ==========================
    const fetchMetadata = async () => {
        try {
            const response = await fetch(`${API_URL}/metadata`);
            if (!response.ok) throw new Error("Metadata fetch failed");

            metadataHierarchy = await response.json();

            const semesters = Object.keys(metadataHierarchy);
            if (semesters.length > 0) {
                populateDropdown('ask-semester', semesters);
                populateDropdown('get-semester', semesters);
                updateSubjects('ask-semester', 'ask-subject');
                updateSubjects('get-semester', 'get-subject');
            }
        } catch (err) {
            console.error("Failed to fetch metadata:", err);
        }
    };

    const populateDropdown = (id, items) => {
        const select = document.getElementById(id);
        if (!select) return;
        select.innerHTML = items.map(item =>
            `<option value="${item}">${item}</option>`
        ).join('');
    };

    const updateSubjects = (semId, subId) => {
        const semSelect = document.getElementById(semId);
        const subSelect = document.getElementById(subId);
        if (!semSelect || !subSelect) return;

        const selectedSem = semSelect.value;
        const subjects = metadataHierarchy[selectedSem] || [];
        populateDropdown(subId, subjects);
    };

    document.getElementById('ask-semester')?.addEventListener('change',
        () => updateSubjects('ask-semester', 'ask-subject'));

    document.getElementById('get-semester')?.addEventListener('change',
        () => updateSubjects('get-semester', 'get-subject'));

    fetchMetadata();

    // ==========================
    // Ask Buddy Logic
    // ==========================
    const sendQuery = document.getElementById('send-query');
    const queryInput = document.getElementById('query-input');
    const chatBox = document.getElementById('chat-box');
    const askSemester = document.getElementById('ask-semester');
    const askSubject = document.getElementById('ask-subject');

    queryInput?.addEventListener('keydown', (e) => {

        if (e.key === 'Enter') sendQuery.click();

        if (e.key === 'Enter' && !e.shiftKey) {
            e.preventDefault();
            sendQuery.click();
        }
    });

    sendQuery?.addEventListener('click', async () => {

        const text = queryInput.value.trim();
        const semester = askSemester.value.trim();
        const subject = askSubject.value.trim();

        if (!text || !semester || !subject) return;

        appendMessage('user', text);
        queryInput.value = '';

        const loadingMsg = appendMessage('model', "Thinking...");

        try {
            const response = await fetch(`${API_URL}/ask`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ question: text, semester, subject })
            });

            if (!response.ok) throw new Error("Server error");

            const data = await response.json();
            console.log("API Response:", data);

            loadingMsg.innerText = data.answer || data.error || "Unexpected response format.";

        } catch (err) {
            console.error("Fetch Error:", err);
            loadingMsg.innerText = "Error: Could not connect to the backend server.";
        }
    });

    // ==========================
    // Generate Questions Logic
    // ==========================
    const generateBtn = document.getElementById('generate-btn');
    const getSemester = document.getElementById('get-semester');
    const getSubject = document.getElementById('get-subject');
    const questionsResult = document.getElementById('questions-result');

    generateBtn?.addEventListener('click', async () => {

        const semester = getSemester.value.trim();
        const subject = getSubject.value.trim();
        if (!semester || !subject) return;

        generateBtn.innerText = "Generating...";
        generateBtn.disabled = true;
        questionsResult.classList.remove('hidden');
        questionsResult.innerText = "Generating questions...";

        try {
            const response = await fetch(`${API_URL}/generate-questions`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ semester, subject })
            });

            if (!response.ok) throw new Error("Server error");

            const data = await response.json();
            questionsResult.innerText = data.questions || data.error || "No questions found.";

        } catch (err) {
            console.error("Fetch Error:", err);
            questionsResult.innerText = "Error: Backend server is unreachable.";
        } finally {
            generateBtn.innerText = "Generate Questions";
            generateBtn.disabled = false;
        }
    });

    // ==========================
    // Chat Message Helper
    // ==========================
    const appendMessage = (sender, text) => {
        const div = document.createElement('div');
        div.classList.add('message', sender);
        div.innerText = text;
        chatBox.appendChild(div);
        chatBox.scrollTop = chatBox.scrollHeight;
        return div;
    };
});
