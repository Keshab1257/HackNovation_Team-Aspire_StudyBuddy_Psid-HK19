from google import genai
import os

# Use the key from rag_engine.py
api_key = os.getenv("GEMINI_API_KEY")

try:
    client = genai.Client(api_key=api_key)
    print("Checking available models...")
    for model in client.models.list():
        print(f"- {model.name}")
except Exception as e:
    print(f"Error listing models: {e}")
##