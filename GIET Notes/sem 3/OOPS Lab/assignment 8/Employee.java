import java.lang.*;
import java.util.*;

public class Employee {
    static Scanner sc = new Scanner(System.in);
    String name;
    int salary, hireYear;

    Employee(String n, int s, int h) {
        name = n;
        salary = s;
        hireYear = h;
    }

    public void yearOfService(int currentYear) {
        System.out.println("You have worked for " + (currentYear - hireYear) + " years in the company.");
    }

    public void display(Scanner sc) { 
        System.out.print("Enter current year:- ");
        int currentYear = sc.nextInt();
        System.out.println("\nEmployee Details:- ");
        System.out.println("Name   :- " + name);
        System.out.println("Salary :- " + salary);
        yearOfService(currentYear);
    }

    public static void main(String[] args) {
        System.out.print("Enter name:- ");
        String name = sc.nextLine();
        System.out.print("Enter salary:- ");    
        int salary = sc.nextInt(); 
        System.out.print("Enter hire year:- ");    
        int hireYear = sc.nextInt();
        Employee emp = new Employee(name, salary, hireYear);
        emp.display(sc);
        sc.close();
    }
}
