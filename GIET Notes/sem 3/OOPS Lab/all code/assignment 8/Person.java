import java.lang.*;
import java.util.*;

public class Person{
    String name;
    int age;

    Person(String inpName, int inpAge){
        name = inpName;
        age = inpAge;
    }

    public void display(){
        System.out.println("Name:- " + name + " and age:- " + age + "\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name:- ");
        String name = sc.nextLine();
        System.out.print("Enter age:- ");    
        int age = sc.nextInt(); 
        Person p1 = new Person(name, sc.nextInt());
        p1.display();

        sc.nextLine();
        System.out.print("Enter name:- ");
        name = sc.nextLine();
        System.out.print("Enter age:- ");    
        age = sc.nextInt(); 
        Person p2 = new Person(name, age);
        p2.display();
        sc.close();
    }
}