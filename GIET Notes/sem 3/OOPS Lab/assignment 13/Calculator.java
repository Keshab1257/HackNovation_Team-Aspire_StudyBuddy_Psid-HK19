import java.lang.*;
import java.util.*; 
import Rajesh.arithmetic.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Multiplication mul = new Multiplication();
        Division div = new Division();

        System.out.print("Enter first number (int) :- ");
        int a = sc.nextInt();
        System.out.print("Enter second number (int) :- ");
        int b = sc.nextInt();
        System.out.println("Multiplication of " + a + " and " + b + " is " + mul.multiply(a, b));
        System.out.println("Division of " + a + " and " + b + " is " + div.divide(a, b));

        System.out.print("\nEnter first number (double) :- ");
        double x = sc.nextDouble();
        System.out.print("Enter second number (double) :- ");
        double y = sc.nextDouble();
        System.out.println("Multiplication of " + x + " and " + y + " is " + mul.multiply(x, y));
        System.out.println("Division of " + x + " and " + y + " is " + div.divide(x, y));
        
        sc.close();
    }
}
