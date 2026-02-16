import java.lang.*;
import java.util.*;
public class Book {
   String title, author;
   float price;
   
    Book(){
        title = "Unknown";
        author = "Unknown";
        price = 0.0f;
    }

    Book(String t, String a){
        title = t;
        author = a;
        price = 0.0f;
    }

    Book(String t, String a, float p){
        title = t;
        author = a;
        price = p;
    }

    public void display(){
        System.out.println("Title:- " + title);
        System.out.println("Author:- " + author);
        System.out.println("Price:- " + price + "\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book b1 = new Book();
        System.out.println("Details of book 1:- ");
        b1.display();

        System.out.print("Enter title of book:- ");
        String t = sc.nextLine();
        System.out.print("Enter author of book:- ");
        String a = sc.nextLine();
        Book b2 = new Book(t, a);
        System.out.println("Details of book 2:- ");
        b2.display();

        System.out.print("Enter price of book:- ");
        float p = sc.nextFloat();
        Book b3 = new Book(t, a, p);
        System.out.println("Details of book 3:- ");
        b3.display();

        sc.close();
    }
}
