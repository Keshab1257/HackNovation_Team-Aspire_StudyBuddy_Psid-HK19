import os
from openai import OpenAI
from retrival_engine import CollegeRetriever
from dotenv import load_dotenv

load_dotenv()
client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))
# client = OpenAI(
#     api_key=os.getenv("OPENROUTER_API_KEY"),
#     base_url="https://openrouter.ai/api/v1",
# )


class CollegeRAG:

    def __init__(self):
        self.retriever = CollegeRetriever()

    # ==========================================================
    # ACADEMIC DOUBT RESOLUTION
    # ==========================================================
    def generate_answer(self, question, semester, subject, previous_question=None):

        if previous_question:
            question = previous_question + " " + question

        retrieved_docs = self.retriever.retrieve(
            f"{subject} {semester} {question}",
            semester,
            subject
        )

        context = "\n\n".join([doc["content"] for doc in retrieved_docs])

        prompt = f"""
You are a friendly academic tutor for GIET students.

Explain in very simple English.
Use short sentences.
Use examples.
Avoid complex words.
Do not use markdown formatting.
Don't go for making bold or italics.

Context:
{subject} {semester}
{context}

Question:
{question}

Answer clearly.
"""

        response = client.chat.completions.create(
            model="gpt-4o-mini",
            messages=[
                {"role": "system", "content": "You are a helpful academic assistant."},
                {"role": "user", "content": prompt}
            ],
            temperature=0.3
        )

        return response.choices[0].message.content

    # ==========================================================
    # SEMESTER QUESTION PAPER GENERATOR
    # ==========================================================
    def generate_questions(self, semester, subject):

        query = f"{subject} {semester} syllabus important topics"

        retrieved_docs = self.retriever.retrieve(
            query,
            semester=semester,
            subject=subject,
            top_k=15,
            threshold=0.25
        )

        if not retrieved_docs:
            return "No academic material found for this subject."

        context = "\n\n".join([doc["content"] for doc in retrieved_docs])

        prompt = f"""
           You are a University Examination Paper Setter.
            Generate a University End-Semester Question Paper STRICTLY based only on the syllabus content provided below.

            IMPORTANT INSTRUCTIONS:

            Do NOT introduce topics outside the given syllabus.

            Do not use markdown formatting.

            Do not use bold or italics.

            Maintain strict academic and university examination tone.

            Follow the exact structural format given below.

            Display marks in the right margin format (for example: 15).

            Mention CO and Bloom’s Level for every question in a separate aligned format.

            Ensure internal choice using (OR) wherever shown.

            Avoid repetition of topics across questions.

            Cover multiple units if available in syllabus.

            Do NOT provide answers.

            Follow this EXACT STRUCTURE:

            QP Code: [Auto Generate Code] Reg. No: ____________

            [UNIVERSITY NAME]
            [Program] ([Semester]) Regular Examinations, [Month – Year]
            [Subject Code] – [Subject Name]
            ([Specialization if any])

            Time: 3 hrs Maximum: 70 Marks

            (The figures in the right hand margin indicate marks)

            PART – A (2 × 5 = 10 Marks)

            Q.1 Answer ALL questions

            a. Question text 2 CO__ K__
            b. Question text 2 CO__ K__
            c. Question text 2 CO__ K__
            d. Question text 2 CO__ K__
            e. Question text 2 CO__ K__

            PART – B (15 × 4 = 60 Marks)

            Answer ALL questions

            2.a Question text 15 CO__ K__
            (OR)
            2.b Question text 15 CO__ K__

            3.a Question text 15 CO__ K__
            (OR)
            3.b Question text 15 CO__ K__

            4.a Question text 15 CO__ K__
            (OR)
            4.b Question text 15 CO__ K__

            5.a Question text 15 CO__ K__
            (OR)
            5.b Question text 15 CO__ K__

            Additional Requirements:

            K1 to K6 must represent Bloom’s Taxonomy levels.

            Distribute Bloom’s levels logically (not all K1).

            CO numbers must be derived logically from syllabus topics.

            Internal choices (OR) must belong to the same unit.

            Questions must include conceptual, analytical and application-based types.

            Syllabus Content:
            {subject}
            {semester}
            Important Topics:
            {context}
            """

        response = client.chat.completions.create(
            model="gpt-4o-mini",
            messages=[
                {"role": "system", "content": "You generate university exam question papers."},
                {"role": "user", "content": prompt}
            ],
            temperature=0.3
        )

        return response.choices[0].message.content

    # ==========================================================
    # PRE-PLACEMENT TRAINING MODULE
    # ==========================================================
    def preplacement_training(self, training_type, user_query):

        training_type = training_type.lower().strip()

        if training_type == "communication":
            trainer_role = """
    You are a professional corporate communication trainer.

    Your goal:
    - Do not use markdown formatting.
    - don't go for making bold or italics.
    - Improve clarity of speech
    - Improve confidence
    - Improve interview communication

    You must:
    - Correct mistakes if any
    - Suggest better sentence framing
    - Give short practice tasks
    - Keep tone motivating but professional
    """
        elif training_type == "aptitude":
            trainer_role = """
    You are an aptitude trainer preparing students for placement tests.

    You must:
    - Solve step-by-step
    - Explain reasoning clearly
    - Show logical breakdown
    - After solving, give one similar practice question
    - Encourage analytical thinking
    """
        elif training_type == "technical":
            trainer_role = """
    You are a technical interviewer conducting placement interviews.

    You must:
    - Ask probing questions
    - Evaluate depth of understanding
    - Provide constructive feedback
    - Suggest improvement areas
    - Keep the environment realistic like a real interview
    """
        else:
            return "Invalid training type. Please choose: communication, aptitude, or technical."

        prompt = f"""
    {trainer_role}

    Now respond to the student's query realistically.

    Student Query:
    {user_query}

    Respond naturally like a real trainer.
 
    Keep it structured and practical.
    """

        response = client.chat.completions.create(
            model="gpt-4o-mini",
            messages=[
                {"role": "system", "content": "You are a professional placement trainer."},
                {"role": "user", "content": prompt}
            ],
            temperature=0.4
        )

        return response.choices[0].message.content