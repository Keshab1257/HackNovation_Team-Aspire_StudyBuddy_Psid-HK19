import json
from collections import Counter

with open("classified_documents.json", "r", encoding="utf-8") as f:
    docs = json.load(f)

types = Counter(doc["academic_type"] for doc in docs)

print("Total documents:", len(docs))
print("Distribution:")
for k, v in types.items():
    print(f"{k}: {v}")
