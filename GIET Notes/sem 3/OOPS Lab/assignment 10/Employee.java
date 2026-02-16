import java.lang.*;
import java.util.*;
class Person {
    static Scanner sc = new Scanner(System.in);
    String fname, lname, jobTitle;

    void getFirstName(){
        System.out.print("Enter your first name :- ");
        fname = sc.nextLine();
    }
    void getLastName(){
        System.out.print("Enter your Last Name :- ");
        lname = sc.nextLine();
    }
}

public class Employee extends Person{
    int empID;

    void getEmployeeID(){
        System.out.print("Enter your Employee ID :- ");
        empID = sc.nextInt();
    }

    void getLastName(){
        super.getLastName();
        System.out.print("Enter your job title :- ");
        jobTitle = sc.nextLine();
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.getFirstName();
        emp.getLastName();
        emp.getEmployeeID();

        System.out.println("\nEmployee details :- ");
        System.out.println("Employee ID :- " + emp.empID);
        System.out.println("First Name :- " + emp.fname);
        System.out.println("Last Name :- " + emp.lname);
        System.out.println("Job Title :- " + emp.jobTitle);

        sc.close();
    }
}
