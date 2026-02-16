from google import genai
from retrival_engine import CollegeRetriever


import os
client = genai.Client(api_key=os.getenv("GEMINI_API_KEY"))


class CollegeRAG:

    def __init__(self):
        self.retriever = CollegeRetriever()

    def generate_answer(self, question, semester, subject):

        results = self.retriever.retrieve(
            question=question,
            semester=semester,
            subject=subject,
            top_k=5,
            threshold=0.50
        )

        if not results:
            return "This topic does not appear in the academic materials for this semester."

        context = "\n\n".join([r["content"] for r in results])

        prompt = f"""
You are a college exam assistant.
Answer in structured university exam format.
Use only the provided context.

Context:
{context}

Question:
{question}
"""

        response = client.models.generate_content(
            model="gemini-2.0-flash",
            contents=prompt
        )

        return response.text
    

    def generate_questions(self, semester, subject):

        results = self.retriever.retrieve(
            question=subject,
            semester=semester,
            subject=subject,
            top_k=15,
            threshold=0.30
        )

        if not results:
            return "No academic material found for this subject."

        context = "\n\n".join([r["content"] for r in results])

        prompt = f"""
    You are a university exam paper setter.

    Using the provided context, generate 10 important exam questions.

    Requirements:
    - Mix short and long answer questions
    - Cover different units if possible
    - Avoid repeating similar questions
    - Make them suitable for semester exams
    -If the topic is not present in the context, do not generate a question about it.
Strictly limit yourself to context.


    Context:
    {context}
    """

        response = client.models.generate_content(
            model="gemini-2.0-flash",
            contents=prompt
        )

        return response.text



