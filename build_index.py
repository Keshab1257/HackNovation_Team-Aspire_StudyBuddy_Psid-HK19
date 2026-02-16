import json
import faiss
import pickle
import numpy as np
from sentence_transformers import SentenceTransformer
from tqdm import tqdm


INPUT_FILE = "chunked_documents.json"
INDEX_FILE = "faiss_index.index"
META_FILE = "metadata.pkl"


def main():
    print("Loading chunks...")
    with open(INPUT_FILE, "r", encoding="utf-8") as f:
        chunks = json.load(f)

    texts = [doc["content"] for doc in chunks]

    print("Loading embedding model...")
    model = SentenceTransformer("all-MiniLM-L6-v2")

    print("Generating embeddings...")
    embeddings = model.encode(
        texts,
        batch_size=64,
        show_progress_bar=True,
        normalize_embeddings=True
    )

    embeddings = np.array(embeddings).astype("float32")

    print("Building FAISS index...")
    dimension = embeddings.shape[1]
    index = faiss.IndexFlatIP(dimension)
    index.add(embeddings)

    print("Saving index...")
    faiss.write_index(index, INDEX_FILE)

    print("Saving metadata...")
    with open(META_FILE, "wb") as f:
        pickle.dump(chunks, f)

    print("Index build complete!")
    print(f"Total vectors indexed: {index.ntotal}")


if __name__ == "__main__":
    main()
