import java.lang.*;
import java.util.*;

public class Employee {
    Scanner sc = new Scanner(System.in);
    String name, job;
    int salary,workedDays;

    public void calculate(){
        System.out.print("Enter the number of days you have worked in this month :- ");
        workedDays = sc.nextInt();
        update((salary / 30) * workedDays);
    }

    public void update(int sal){
        salary = sal;
    }
    public static void main(String[] args) {
        Employee emp = new Employee();
        System.out.print("Enter your name:- ");
        emp.name = emp.sc.nextLine();
        System.out.print("Enter your job:- ");
        emp.job = emp.sc.nextLine();
        System.out.print("Enter your monthly salary:- ");
        emp.salary = emp.sc.nextInt();
        emp.calculate();
        System.out.println("\nName:- " + emp.name);
        System.out.println("Job:- " + emp.job);
        System.out.println("Your this month salary for " + emp.workedDays + " days is:- " + emp.salary);
        emp.sc.close();
    }
    
}