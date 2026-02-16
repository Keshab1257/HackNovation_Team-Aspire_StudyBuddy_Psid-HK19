import java.lang.*;
import java.util.*;

public class Lexicographical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string :- ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string :- ");
        String str2 = sc.nextLine();

        int min = Math.min(str1.length(), str2.length());
        for(int i = 0; i < min; i++) {
            if(str1.charAt(i) > str2.charAt(i)) {
                System.out.println("'" +str1 + "' is greater than '" + str2 + "'.");
                sc.close();
                return;
            }else if(str1.charAt(i) < str2.charAt(i)) {
                System.out.println("'" +str1 + "' is less than '" + str2 + "'.");
                sc.close();
                return;
            }
        }
        
        if(str1.length() > str2.length()) {
            System.out.println("'" + str1 + "' is greater than '" + str2 + "'.");
        } else if(str1.length() < str2.length()) {
            System.out.println("'" + str1 + "' is less than '" + str2 + "'.");
        } else {
            System.out.println("Both strings are equal.");
        }

        sc.close();
    }    
}
