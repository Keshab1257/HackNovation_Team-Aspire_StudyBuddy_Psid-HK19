import os
import json
from flask import Flask, request, jsonify
from flask_cors import CORS
from rag_engine import CollegeRAG

app = Flask(__name__)
CORS(app)  # Enable CORS for frontend integration

# Initialize RAG Engine
print("Initializing RAG Engine... this may take a moment.")
rag = CollegeRAG()

@app.route('/api/metadata', methods=['GET'])
def get_metadata():
    try:
        metadata = rag.retriever.metadata
        
        # Filter and structure metadata
        hierarchy = {}
        for m in metadata:
            sem = m.get('semester', '').strip()
            sub = m.get('subject', '').strip()
            
            # Skip empty or "lab" content
            if not sem or not sub:
                continue
            if 'lab' in sem.lower() or 'lab' in sub.lower():
                continue
                
            if sem not in hierarchy:
                hierarchy[sem] = set()
            hierarchy[sem].add(sub)
            
        # Convert sets to sorted lists for JSON
        formatted_hierarchy = {
            sem: sorted(list(subs)) 
            for sem, subs in sorted(hierarchy.items())
        }
        
        return jsonify(formatted_hierarchy)
    except Exception as e:
        return jsonify({"error": str(e)}), 500

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

@app.route('/api/upload', methods=['POST'])
def upload_file():
    # Placeholder for file upload logic
    # In a real scenario, we would save the file to the appropiate directory
    # and maybe trigger a re-index.
    if 'file' not in request.files:
        return jsonify({"error": "No file part"}), 400
    
    file = request.files['file']
    if file.filename == '':
        return jsonify({"error": "No selected file"}), 400

    # For now, just simulate success
    return jsonify({"message": f"File {file.filename} submitted for verification!"})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=False)
