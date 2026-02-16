import requests

BASE_HEADERS = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64)",
    "Accept": "application/json, text/javascript, */*",
    "Content-Type": "application/json;charset=UTF-8",
    "Origin": "https://gietuerp.in",
    "Referer": "https://gietuerp.in/",
}

def get_student_image(roll):
    url = f"https://gietuerp.in/Student/GetStudentImage?rollno={roll}"
    res = requests.get(url, headers=BASE_HEADERS)
    return url if res.status_code == 200 else None


def get_exam_data(roll):
    """Step 1: Get exam schedule (same as first AJAX call)"""
    url = "https://gietuerp.in/ExamReport/GetAllScheduledExamForStudents"
    payload = {
        "filterForStudentExamReport": {
            "intSemester": -1,
            "vchRollNo": roll,
            "intExamTypeID": 0
        }
    }

    r = requests.post(url, json=payload, headers=BASE_HEADERS)
    print("First API status:", r.status_code)
    print("First API:", r.text)

    data = r.json()

    if "data" not in data or len(data["data"]) == 0:
        return None  # no data returned

    return data["data"]


def get_marks(student_id, schedule_id):
    """Step 2: call second AJAX (subject marks)"""
    url = "https://gietuerp.in/ExamReport/GetAllSubjectMarksForStudents"
    payload = {
        "intExamScheduleMasterID": schedule_id,
        "intStudentID": student_id
    }

    r = requests.post(url, json=payload, headers=BASE_HEADERS)
    print(f"Second API {schedule_id}:", r.text)

    return r.json().get("data", [])


def get_full_report(roll):
    # Get student image URL
    image_url = get_student_image(roll)

    # Step 1: get exam schedule
    exam_list = get_exam_data(roll)
    if exam_list is None:
        return None

    student_id = exam_list[0]["intStudentID"]
    schedule_ids = [x["intExamScheduleMasterID"] for x in exam_list]

    final_report = {
        "roll": roll,
        "student_image": image_url,
        "exams": []
    }

    # Step 2: Loop exam IDs
    for exam in exam_list:
        exam_id = exam["intExamScheduleMasterID"]

        marks = get_marks(student_id, exam_id)

        final_report["exams"].append({
            "exam_id": exam_id,
            "exam_name": exam["vchExamName"],
            "total": exam["decTotalMark"],
            "secured": exam["decMarkSecured"],
            "subjects": marks
        })

    return final_report


if __name__ == "__main__":
    roll = "24CSEAIML015"
    report = get_full_report(roll)
    print("\nFINAL REPORT:")
    print(report)
