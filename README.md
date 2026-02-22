# 📚 GIET Study Buddy

> An AI-powered academic assistant built for students of GIET University — ask questions, generate exam papers, and contribute to a shared knowledge base.

---
## ❗ Problem Statement

Students often use generic AI tools to clear academic doubts. However, these tools are not syllabus-aware and do not understand GIET University’s semester-wise curriculum. They may provide overly complex explanations, off-syllabus content, or even incorrect and hallucinated answers.

Because of this, students experience confusion instead of clarity. There is currently no dedicated AI system that is aligned with GIET’s subjects, semesters, and academic structure.

A controlled, context-aware, and syllabus-grounded academic assistant is needed to ensure accurate and reliable learning support.

---

## ✅ Our Solution

GIET Study Buddy is a syllabus-aware AI academic assistant designed specifically for GIET University students.

It solves the problem by:

- Using Retrieval-Augmented Generation (RAG) to generate answers grounded in actual GIET syllabus and notes
- Organizing content by semester and subject for structured learning
- Allowing students to generate university-style exam questions
- Enabling community contributions with admin moderation and verification
- Ensuring answers are accurate, context-aware, and classroom-aligned

Instead of being a generic chatbot, GIET Study Buddy acts as a trusted academic companion built specifically for the GIET ecosystem.

---

## ✨ Features

- 🤖 **AI Tutor** — Ask subject-specific questions and get answers powered by OpenAI, grounded in your actual syllabus via RAG
- 📝 **Exam Question Generator** — Generate 10 important university-style questions for any subject and semester
- 📂 **Structured Library** — Notes and PYQs organized by semester and subject, queryable through the RAG pipeline
- 🙌 **Community Contributions** — Students can upload PDFs, PPTs, and images to grow the knowledge base
- 🛡️ **Admin Moderation** — Uploaded content goes through a verification step before being indexed

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Frontend | HTML, CSS, Vanilla JavaScript |
| Backend | Python, Flask |
| AI | OpenAI API (GPT) |
| Retrieval | RAG (Retrieval-Augmented Generation) |
| Document Store | Vector store for embedded syllabus & notes |

---

## 🗂️ Project Structure

```
GDG/
├── frontend/                      # Frontend (HTML, CSS, JS)
│   ├── index.html                 # Main app — single-page with all sections
│   ├── landing.html               # Landing / intro page
│   ├── index.css                  # Styles
│   ├── app.js                     # Client-side logic & API calls
│   └── logo.png                   # App logo
│
├── avavilable syllabus/           # Raw syllabus documents by subject/semester
├── GIET Notes/                    # Uploaded and verified student notes
├── __pycache__/                   # Python cache (auto-generated)
├── venv/                          # Python virtual environment
│
├── server.py                      # Flask server — main entry point & API routes
├── rag_engine.py                  # RAG pipeline (retrieve + generate answers)
├── retrival_engine.py             # Vector similarity retrieval logic
├── content_classifier.py          # Classifies documents by subject/semester
├── extractor.py                   # Extracts text from PDFs, PPTs, images
├── chunk_documents.py             # Splits documents into chunks for embedding
├── build_index.py                 # Builds the FAISS vector index
├── build_raw_dataset.py           # Prepares raw dataset from source documents
├── list_models.py                 # Lists available OpenAI models
├── stats.py                       # Usage/stats utilities
│
├── faiss_index.index              # FAISS vector index (built from documents)
├── metadata.pkl                   # Metadata store for indexed chunks
├── chunked_documents.json         # Chunked document store
├── classified_documents.json      # Documents classified by subject/semester
├── raw_documents.json             # Raw extracted document data
│
├── rag_test.py                    # Test script for RAG pipeline
├── test_gen.py                    # Test script for question generation
├── test_question.py               # Test script for Q&A
├── test_retrival.py               # Test script for retrieval engine
├── tst.py                         # General test/scratch script
│
├── .env                           # API keys — not committed to version control
├── .gitignore                     # Git ignore rules
├── requirements.txt               # Python dependencies
└── README.md                      # Project documentation
```

---

## 🚀 Getting Started

### Prerequisites

- Python 3.9+
- OpenAI API key

### Installation

```bash
# Clone the repository
git clone https://github.com/your-username/GIET-Study-Buddy.git
cd GIET-Study-Buddy

# Install Python dependencies
pip install -r requirements.txt

# Set up environment variables
cp .env.example .env
# Add your OpenAI API key to .env
```

### Environment Variables

Create a `.env` file in the root directory:

```env
OPENAI_API_KEY=your_openai_api_key_here
FLASK_ENV=development
FLASK_PORT=5000
```

### Running the App

```bash
# Start the Flask backend
python backend/app.py

# Open frontend/index.html in your browser
# or serve it via Flask's static file serving
```

---

## 🔌 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/metadata` | Fetch available semesters and subjects |
| `POST` | `/api/ask` | Ask a question (RAG-powered answer) |
| `POST` | `/api/generate-questions` | Generate exam questions for a subject |
| `POST` | `/api/contribute` | Submit a document for verification |

### Example Request — Ask a Question

```json
POST /api/ask
{
  "question": "Explain the concept of normalization in DBMS",
  "semester": "Semester 3",
  "subject": "Database Management Systems"
}
```

### Example Response

```json
{
  "answer": "Normalization is the process of organizing a database to reduce redundancy..."
}
```

---

## 🧠 How RAG Works

1. **Ingest** — Uploaded documents (PDFs, PPTs) are parsed and split into chunks
2. **Embed** — Each chunk is converted into a vector embedding using OpenAI's embedding model
3. **Store** — Embeddings are stored in a vector store indexed by semester and subject
4. **Retrieve** — On a user query, the most relevant chunks are retrieved via similarity search
5. **Generate** — The retrieved context is passed to GPT along with the user's question to produce a grounded answer

---

## 📌 Status

🚧 **Active Development** — Core features are functional. Contribution verification and admin panel are in progress.

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License.

---

## 👤 Author

Built with ❤️ for GIET University students.
