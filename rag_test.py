from rag_engine import CollegeRAG

rag = CollegeRAG()

answer = rag.generate_answer(
    question="Explain Laplace Transform",
    semester="sem 2",
    subject="math"
)

print("\nGenerated Answer:\n")
print(answer)
