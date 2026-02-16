import os
import json
from extractor import extract_text, detect_file_type
from tqdm import tqdm


DATA_ROOT = "D:\\GDG\\GIET Notes"
OUTPUT_FILE = "raw_documents.json"


def scan_dataset():
    documents = []

    for semester in os.listdir(DATA_ROOT):
        sem_path = os.path.join(DATA_ROOT, semester)

        if not os.path.isdir(sem_path):
            continue

        for subject in os.listdir(sem_path):
            subject_path = os.path.join(sem_path, subject)

            if not os.path.isdir(subject_path):
                continue

            for file in os.listdir(subject_path):
                file_path = os.path.join(subject_path, file)

                if not os.path.isfile(file_path):
                    continue

                file_type = detect_file_type(file_path)

                if file_type == "unknown":
                    continue

                try:
                    text = extract_text(file_path)

                    if len(text.strip()) < 50:
                        continue

                    documents.append({
                        "semester": semester,
                        "subject": subject,
                        "file_name": file,
                        "file_type": file_type,
                        "raw_text": text
                    })

                except Exception as e:
                    print(f"Error processing {file_path}: {e}")

    return documents


if __name__ == "__main__":
    docs = scan_dataset()

    with open(OUTPUT_FILE, "w", encoding="utf-8") as f:
        json.dump(docs, f, indent=2, ensure_ascii=False)

    print(f"Saved {len(docs)} documents to {OUTPUT_FILE}")
