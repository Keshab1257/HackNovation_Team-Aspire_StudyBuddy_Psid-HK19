import json
import re

INPUT_FILE = "classified_documents.json"
OUTPUT_FILE = "chunked_documents.json"


# -----------------------------
# SYLLABUS CHUNKING
# -----------------------------

def chunk_syllabus(text):
    units = re.split(r"(UNIT-\s*\d+.*)", text)
    chunks = []

    for i in range(1, len(units), 2):
        header = units[i]
        content = units[i+1] if i+1 < len(units) else ""
        chunk = header + "\n" + content
        if len(chunk.strip()) > 100:
            chunks.append(chunk.strip())

    return chunks


# -----------------------------
# PYQ CHUNKING
# -----------------------------

def chunk_pyq(text):
    questions = re.split(r"\n(?=\d+\)|Q\.|Question)", text)
    return [q.strip() for q in questions if len(q.strip()) > 100]


# -----------------------------
# LAB CHUNKING
# -----------------------------

def chunk_lab(text):
    experiments = re.split(r"\n(?=Experiment|\d+\.)", text)
    return [e.strip() for e in experiments if len(e.strip()) > 100]


# -----------------------------
# NOTES CHUNKING
# -----------------------------

def chunk_notes(text, chunk_size=500, overlap=100):
    words = text.split()
    chunks = []
    start = 0

    while start < len(words):
        end = start + chunk_size
        chunk = " ".join(words[start:end])
        chunks.append(chunk)
        start += chunk_size - overlap

    return chunks


# -----------------------------
# MAIN
# -----------------------------

def main():
    with open(INPUT_FILE, "r", encoding="utf-8") as f:
        docs = json.load(f)

    chunked_docs = []

    for doc in docs:
        text = doc["raw_text"]
        doc_type = doc["academic_type"]

        if doc_type == "syllabus":
            chunks = chunk_syllabus(text)

        elif doc_type == "pyq":
            chunks = chunk_pyq(text)

        elif doc_type == "lab":
            chunks = chunk_lab(text)

        else:
            chunks = chunk_notes(text)

        for chunk in chunks:
            chunked_docs.append({
                "semester": doc["semester"],
                "subject": doc["subject"],
                "file_name": doc["file_name"],
                "academic_type": doc_type,
                "content": chunk
            })

    with open(OUTPUT_FILE, "w", encoding="utf-8") as f:
        json.dump(chunked_docs, f, indent=2, ensure_ascii=False)

    print(f"Total chunks created: {len(chunked_docs)}")


if __name__ == "__main__":
    main()
