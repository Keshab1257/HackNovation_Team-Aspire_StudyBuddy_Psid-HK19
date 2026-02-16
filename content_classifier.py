import json
import re

INPUT_FILE = "raw_documents.json"
OUTPUT_FILE = "classified_documents.json"


def classify_document(text):

    text_upper = text.upper()

    # Syllabus detection
    if ("SYLLABUS" in text_upper and "UNIT-" in text_upper) or \
       "COURSE OUTCOMES" in text_upper or \
       "CO-PO MAPPING" in text_upper:
        return "syllabus"

    # Lab detection
    if "LIST OF EXPERIMENTS" in text_upper or \
       "EXPERIMENT-" in text_upper or \
       "LABORATORY" in text_upper:
        return "lab"

    # PYQ detection
    if re.search(r"\bQ\.\b|\bQUESTION\b|\bMARKS\b|\b20\d{2}\b", text_upper):
        return "pyq"

    return "notes"


def main():
    with open(INPUT_FILE, "r", encoding="utf-8") as f:
        documents = json.load(f)

    for doc in documents:
        doc["academic_type"] = classify_document(doc["raw_text"])

    with open(OUTPUT_FILE, "w", encoding="utf-8") as f:
        json.dump(documents, f, indent=2, ensure_ascii=False)

    print(f"Saved classified documents to {OUTPUT_FILE}")


if __name__ == "__main__":
    main()
