import java.lang.*;
import java.util.*;

public class Library {
    Scanner sc = new Scanner(System.in);
    String books[][];
    int idx = 0, totalBooks = 0;

    public void addBook() {
        for(int i = idx; i < totalBooks; i++) {
            System.out.print("  Enter book Number:- ");
            books[idx][0] = sc.nextInt()+"";
            System.out.print("  Enter book Name:- ");
            sc.nextLine();
            books[idx][1] = sc.nextLine();
            System.out.print("  Enter Author Name:- ");
            books[idx][2] = sc.nextLine();
            idx++;
            System.out.println("Book details added successfully.");
            System.out.println();
        }
    }

    public void removeBook() {
        System.out.print("\nEnter book number to remove:- ");
        int bookNumber = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < idx; i++) {
            if (Integer.parseInt(books[i][0]) == bookNumber) {
                for (int j = i; j < idx - 1; j++) {
                    books[j][0] = books[j + 1][0];
                    books[j][1] = books[j + 1][1];
                    books[j][2] = books[j + 1][2];
                }
                books[idx - 1][0] = null;
                books[idx - 1][1] = null;
                books[idx - 1][2] = null;
                idx--;
                found = true;
                System.out.println("Book removed successfully.");
            }
        }
        if (!found) {System.out.println("Book not found.");
                    removeBook();}
    }

    public void printing() {
        System.out.println("Books in Library:-");
        System.out.println("Book Number\tBook Name\tAuthor Name");
        for (int i = 0; i < idx; i++) {
            System.out.println(books[i][0] + "\t\t" + books[i][1] + "\t\t" + books[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        System.out.print("Enter the total number of books data to be stored :- ");
        lib.totalBooks = sc.nextInt();
        lib.books = new String[lib.totalBooks][3];
        System.out.println("Enter the books details:- ");
        lib.addBook();
        lib.printing();
        lib.removeBook();
        lib.printing();
        sc.close();
    }
}
