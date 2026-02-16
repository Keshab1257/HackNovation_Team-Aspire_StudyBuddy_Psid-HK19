import java.lang.*;
import java.io.*;
public class Palindrome {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number :- ");
        int val = Integer.parseInt(br.readLine());
        int rev = 0, temp = val;
        while(temp != 0){
            rev = (rev * 10) + (temp % 10);
            temp = temp / 10;
        }
        if(val == rev){
            System.out.println(val + " is a palindrome.");
        }
        else{
            System.out.println(val + " is not a palindrome.");
        }
    }
}
