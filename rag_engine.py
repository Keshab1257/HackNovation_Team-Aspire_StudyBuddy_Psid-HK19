import os
from openai import OpenAI
from retrival_engine import CollegeRetriever
from dotenv import load_dotenv
load_dotenv()  # Load environment variables from .env file

import os
client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))

class CollegeRAG:

    def __init__(self):
        self.retriever = CollegeRetriever()

    def generate_answer(self, question, semester, subject, previous_question=None):

        if previous_question:
            question = previous_question + " " + question

        retrieved_docs = self.retriever.retrieve(
            f"{subject} {semester} {question}",
            semester,
            subject
        )
        # if not retrieved_docs:
        #     return "No relevant content found in database."

        context = "\n\n".join([doc["content"] for doc in retrieved_docs])

        prompt = f"""
        You are an academic assistant for GIET students.

        Answer the question using ONLY the provided context.
        If the context does not contain the answer, then give the answers based on your general knowledge of the subject, but prioritize the context.
        Context:
        {subject} {semester} syllabus important topics:
          {context}

        Question:
        {question}

        Answer clearly and concisely.
        """

        response = client.chat.completions.create(
            model="gpt-4o-mini",  # cheap + fast
            messages=[
                {"role": "system", "content": "You are a helpful academic assistant."},
                {"role": "user", "content": prompt}
            ],
            temperature=0.3
        )

        return response.choices[0].message.content

    def generate_questions(self, semester, subject):

        # 🔹 Anchor query to subject strongly
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
    You are a university exam paper setter.

    Generate a structured semester exam question paper STRICTLY based on the given syllabus content.

    Instructions:
    - Do NOT introduce topics not present in context.
    - Cover different units if possible.
    - Avoid repetition.
    - Maintain proper academic tone.

    Structure the paper like this:

    Section A (2 Marks each) – 5 Questions  
    Section B (5 Marks each) – 5 Questions  
    Section C (10 Marks each) – 2 Questions  

    Syllabus Content:
    {subject} {semester} syllabus important topics:
    {context}
    """
#replaced context with subject
        response = client.chat.completions.create(
            model="gpt-4o-mini",
            messages=[
                {"role": "system", "content": "You generate university exam question papers."},
                {"role": "user", "content": prompt}
            ],
            temperature=0.3
        )

        return response.choices[0].message.content