import java.lang.*;
import java.util.*;
public class EvenDigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 7 digit number :- ");
        int val = sc.nextInt();
        System.out.print("The sum of " + val + " is :- ");
        int sum = 0;
        val = val / 10;
        sum += val%10;
        val = val / 100;
        sum += val%10;
        val = val / 100;
        sum += val%10;
        System.out.println(sum);
        sc.close();
    }    
}
