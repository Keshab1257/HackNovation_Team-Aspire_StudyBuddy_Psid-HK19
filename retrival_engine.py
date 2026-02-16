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

    def retrieve(self, question, semester=None, subject=None, top_k=5, threshold=0.55):

        # Embed query
        query_embedding = self.model.encode(
            [question],
            normalize_embeddings=True
        )
        query_embedding = np.array(query_embedding).astype("float32")

        # Search
        scores, indices = self.index.search(query_embedding, top_k)

        results = []

        for score, idx in zip(scores[0], indices[0]):
            chunk = self.metadata[idx]

            # Optional filtering
            if semester and chunk["semester"].strip().lower() != semester.strip().lower():
                continue

            if subject and chunk["subject"].strip().lower() != subject.strip().lower():
                continue

            # Strict Filter: Ignore "lab" content
            if 'lab' in chunk["semester"].lower() or 'lab' in chunk["subject"].lower():
                continue


            if score < threshold:
                continue

            results.append({
                "score": float(score),
                "content": chunk["content"],
                "semester": chunk["semester"],
                "subject": chunk["subject"],
                "type": chunk["academic_type"]
            })

        return results
