import faiss
import pickle
import numpy as np
from sentence_transformers import SentenceTransformer


INDEX_FILE = "faiss_index.index"
META_FILE = "metadata.pkl"


class CollegeRetriever:

    def __init__(self):
        print("Loading FAISS index...")
        self.index = faiss.read_index(INDEX_FILE)

        print("Loading metadata...")
        with open(META_FILE, "rb") as f:
            self.metadata = pickle.load(f)

        print("Loading embedding model...")
        self.model = SentenceTransformer("all-MiniLM-L6-v2")

        print("Total indexed vectors:", self.index.ntotal)
        print("Total metadata entries:", len(self.metadata))


    def retrieve(self, question, semester=None, subject=None, top_k=5, threshold=0.25):

        print("\n========== RETRIEVAL DEBUG ==========")
        print("Incoming Question:", question)
        print("Incoming Semester:", semester)
        print("Incoming Subject:", subject)

        query_embedding = self.model.encode(
            [question],
            normalize_embeddings=True
        )
        query_embedding = np.array(query_embedding).astype("float32")

        scores, indices = self.index.search(query_embedding, top_k)

        results = []

        for score, idx in zip(scores[0], indices[0]):
            chunk = self.metadata[idx]
            score = float(score)

            print("Raw Score:", score)

            # 🔒 Similarity threshold
            if score < threshold:
                continue

            # 🔒 Semester filter
            if semester and semester.lower() not in chunk.get("semester", "").lower():
                continue

            # 🔒 Subject filter
            if subject and subject.lower() not in chunk.get("subject", "").lower():
                continue

            # 🚫 Ignore labs
            if 'lab' in chunk.get("semester", "").lower() or \
            'lab' in chunk.get("subject", "").lower():
                continue

            results.append({
                "score": score,
                "content": chunk.get("content", ""),
                "semester": chunk.get("semester", ""),
                "subject": chunk.get("subject", ""),
                "type": chunk.get("academic_type", "")
            })

        print("Retrieved results count:", len(results))
        print("=====================================\n")

        return results