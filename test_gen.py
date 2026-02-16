from google import genai

import os
api_key = os.getenv("GEMINI_API_KEY")

try:
    client = genai.Client(api_key=api_key)
    print("Testing content generation...")
    response = client.models.generate_content(
        model="gemini-2.0-flash",
        contents="Say hello!"
    )
    print(f"Response: {response.text}")
except Exception as e:
    print(f"Error: {e}")
