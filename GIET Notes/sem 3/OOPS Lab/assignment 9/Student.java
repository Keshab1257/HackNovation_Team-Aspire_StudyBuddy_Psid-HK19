import java.lang.*;

public class Student {
    int StudentID;
    String studentName, grade;

    Student(){
        this(100,"Rajesh Rana","B");
    }

    Student(int StudentID, String studentName, String grade){
        this.StudentID = StudentID;
        this.studentName = studentName;
        this.grade = grade;
    }

    public void display(){
        System.out.println("Student ID:- " + StudentID);
        System.out.println("Student Name:- " + studentName);
        System.out.println("Student Grade:- " + grade);
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}
