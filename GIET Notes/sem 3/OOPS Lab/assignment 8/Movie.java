import java.lang.*;
import java.util.Scanner;

public class Movie {
    String title, director, actor;
    String[] reviews;  
    int reviewCount;    

    Movie(Scanner sc, String t, String d, String a) {
        title = t;
        director = d;
        actor = a;
        addReview(sc);
    }

    public void addReview(Scanner sc) {
        System.out.print("Enter number of reviews you want to allow:- ");
        int maxReviews = sc.nextInt();
        reviews = new String[maxReviews];
        sc.nextLine();
        for (int i = 1; i <= maxReviews; i++) {
            System.out.print("Enter review " + i + " :- ");
            String review = sc.nextLine();
            reviews[reviewCount] = review;
            reviewCount++;
        }
    }

    public String[] getReviews() {
        String res[] = new String[reviewCount];
        for (int i = 0; i < reviewCount; i++) {
            res[i] = reviews[i];
        }
        return res;
    }

    public void display() {
        System.out.println("\nMovie Details:-");
        System.out.println("Title    :- " + title);
        System.out.println("Director :- " + director);
        System.out.println("Actor    :- " + actor);
        System.out.println("Reviews  :-");
        for(String review : getReviews()) {
            System.out.println(" - " + review);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title:- ");
        String title = sc.nextLine();

        System.out.print("Enter director:- ");
        String director = sc.nextLine();

        System.out.print("Enter actor:- ");
        String actor = sc.nextLine();

        Movie movie = new Movie(sc, title, director, actor);

        

        movie.display();
        sc.close();
    }
}
