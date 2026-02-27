import os
from flask import Flask, request, jsonify, send_from_directory
from flask_cors import CORS
from rag_engine import CollegeRAG
from dotenv import load_dotenv

load_dotenv()

app = Flask(__name__)
CORS(app)

print("Initializing RAG Engine...")
rag = CollegeRAG()


# ===============================
# Serve Frontend
# ===============================
@app.route('/')
def serve_frontend():
    return send_from_directory('frontend', 'landing.html')

@app.route('/frontend/<path:filename>')
def serve_static_files(filename):
    return send_from_directory('frontend', filename)


# ===============================
# Academic Metadata
# ===============================
@app.route('/api/metadata', methods=['GET'])
def get_metadata():
    try:
        metadata = rag.retriever.metadata

        hierarchy = {}
        for m in metadata:
            sem = m.get('semester', '').strip()
            sub = m.get('subject', '').strip()

            if not sem or not sub:
                continue
            if 'lab' in sem.lower() or 'lab' in sub.lower():
                continue

            if sem not in hierarchy:
                hierarchy[sem] = set()
            hierarchy[sem].add(sub)

        formatted_hierarchy = {
            sem: sorted(list(subs))
            for sem, subs in sorted(hierarchy.items())
        }

        return jsonify(formatted_hierarchy)

    except Exception as e:
        return jsonify({"error": str(e)}), 500


# ===============================
# Academic Doubt Resolver
# ===============================
@app.route('/api/ask', methods=['POST'])
def ask_question():
    data = request.json

    question = data.get('question')
    semester = data.get('semester')
    subject = data.get('subject')

    if not all([question, semester, subject]):
        return jsonify({"error": "Missing required fields"}), 400

    try:
        answer = rag.generate_answer(question, semester, subject)
        return jsonify({"answer": answer})

    except Exception as e:
        return jsonify({"error": str(e)}), 500


# ===============================
# Question Generator
# ===============================
@app.route('/api/generate-questions', methods=['POST'])
def generate_questions():
    data = request.json

    semester = data.get('semester')
    subject = data.get('subject')

    if not all([semester, subject]):
        return jsonify({"error": "Missing required fields"}), 400

    try:
        questions = rag.generate_questions(semester, subject)
        return jsonify({"questions": questions})

    except Exception as e:
        return jsonify({"error": str(e)}), 500


# ===============================
# Pre-Placement Training API
# ===============================
@app.route('/api/preplacement-training', methods=['POST'])
def preplacement_training():

    data = request.json

    training_type = data.get('training_type')
    user_query = data.get('user_query')

    if not training_type or not user_query:
        return jsonify({"error": "Missing required fields"}), 400

    try:
        result = rag.preplacement_training(training_type, user_query)
        return jsonify({"answer": result})   

    except Exception as e:
        print("PREPLACEMENT API ERROR:", e)
        return jsonify({"error": str(e)}), 500


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)