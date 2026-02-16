import sys
import urllib.request
import mimetypes
import uuid
import os

# Your tinyurl upload endpoint
UPLOAD_URL = "https://script.google.com/macros/s/AKfycbzlezOZHPMq895aEe9fH6KBqILsOpkmslWDJ_qCxH0SoJmsahAGUp8psR2fjQs0AWXJgw/exec"

def upload(file_path):
    if not os.path.isfile(file_path):
        print("Error: File does not exist:", file_path)
        return
    
    filename = os.path.basename(file_path)

    # Generate MIME type
    mime_type = mimetypes.guess_type(file_path)[0] or "application/octet-stream"

    # Build POST multipart/form-data request manually
    boundary = uuid.uuid4().hex
    data_pre = (
        f"--{boundary}\r\n"
        f'Content-Disposition: form-data; name="file"; filename="{filename}"\r\n'
        f"Content-Type: {mime_type}\r\n\r\n"
    ).encode()

    data_post = f"\r\n--{boundary}--\r\n".encode()

    with open(file_path, "rb") as f:
        file_data = f.read()

    body = data_pre + file_data + data_post

    req = urllib.request.Request(UPLOAD_URL, data=body)
    req.add_header("Content-Type", f"multipart/form-data; boundary={boundary}")
    req.add_header("Content-Length", str(len(body)))

    try:
        response = urllib.request.urlopen(req)
        print(response.read().decode())
    except Exception as e:
        print("Upload failed:", e)


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python upload.py <file>")
    else:
        upload(sys.argv[1])
