import os
from openai import OpenAI
from retrival_engine import CollegeRetriever
from dotenv import load_dotenv

load_dotenv()

client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))


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
You are a University Semester Examination Paper Setter.

Generate a structured End-Semester Question Paper STRICTLY based on the syllabus.

Structure:
SECTION A – 5 Questions (2 Marks each)
SECTION B – 5 Questions (5 Marks each)
SECTION C – 2 Questions (10 Marks each)

Do NOT provide answers.

Syllabus:
{subject}
{semester}
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
    Do not use markdown formatting.
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