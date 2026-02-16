from retrival_engine import CollegeRetriever

retriever = CollegeRetriever()

query = "Explain Laplace Transform"

results = retriever.retrieve(
    question=query,
    semester="sem 2",
    subject="math",
    top_k=5,
    threshold=0.30
)

print("\nQuery:", query)
print("\nResults found:", len(results))

for i, r in enumerate(results):
    print(f"\nResult {i+1}")
    print("Score:", r["score"])
    print("Type:", r["type"])
    print("Preview:", r["content"][:300])
    print("-" * 80)
