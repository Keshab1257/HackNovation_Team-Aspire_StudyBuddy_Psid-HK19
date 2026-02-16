import java.lang.*;
import java.util.*;

public class StringEqualCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string :- ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string :- ");
        String str2 = sc.nextLine();

        if (str1.length() != str2.length()) {
            System.out.println("The strings are NOT equal.");
            sc.close();
            return;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                System.out.println("The strings are NOT equal.");
                sc.close();
                return;
            }
        }

        System.out.println("The strings are equal.");

        sc.close();
    }
}
