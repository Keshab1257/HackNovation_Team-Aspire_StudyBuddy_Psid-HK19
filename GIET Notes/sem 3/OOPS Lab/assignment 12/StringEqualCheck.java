import java.lang.*;
import java.io.*;

public class StringEqualCheck {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0, i = 0, ch;
        String str1 = ""; 
        System.out.print("Enter first string :- ");
        while((ch = br.read()) != -1) {
            if(ch == '\n') break;
            str1 += (char)ch;
            count++;
        }

        System.out.print("Enter second string :- ");
        while((ch = br.read()) != '\n') {
            if(i >= count || str1.charAt(i) != (char)ch) {
                System.out.println("The strings are not equal.");
                return;
            }
            i++;
        }

        if(i != count) {
            System.out.println("The strings are not equal.");
        } else {
            System.out.println("The strings are equal.");
        }
    }
}
