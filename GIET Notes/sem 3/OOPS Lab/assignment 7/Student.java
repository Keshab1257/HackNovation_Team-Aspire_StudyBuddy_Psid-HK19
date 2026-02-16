import java.lang.*;
import java.util.*;

public class Student {
    Scanner sc = new Scanner(System.in);
    String name, rollno, course;

    public void courses(){
        System.out.println("Available courses:-");
        System.out.println("1. B.Tech");
        System.out.println("2. B.Sc");
        System.out.println("3. B.Com");
        System.out.println("4. BBA");
        System.out.println("5. MBA");
        System.out.print("Enter your course index:- ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1: 
                course = "B.Tech"; 
                break;
            case 2: 
                course = "B.Sc"; 
                break;
            case 3: 
                course = "B.Com"; 
                break;
            case 4: 
                course = "BBA"; 
                break;
            case 5: 
                course = "MBA"; 
                break;
            default: 
                System.out.println("Enter a valid course index.");
                courses();
        }
    }

    public void StudentDetails(){
        System.out.println("Name:- " + name);
        System.out.println("Roll No:- " + rollno);
        System.out.println("Course Selected:- " + course);
    }

    public static void main(String[] args) {
        Student std = new Student();
        System.out.print("Enter your name:- ");
        std.name = std.sc.nextLine();
        System.out.print("Enter your roll number:- ");
        std.rollno = std.sc.nextLine();
        std.courses();
        std.StudentDetails();
        std.sc.close();
    }
}
