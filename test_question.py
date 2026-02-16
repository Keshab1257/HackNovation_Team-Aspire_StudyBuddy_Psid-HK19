from rag_engine import CollegeRAG

rag = CollegeRAG()

questions = rag.generate_questions(
    semester="sem 2",
    subject="math"
)

print("\nGenerated Questions:\n")
print(questions)
