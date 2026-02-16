import java.lang.*;
import java.util.*;

public class NumberException{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:- ");
        String input = sc.nextLine();
        try {
            int number = Integer.parseInt(input);
            System.out.println("The Square of " + number + " is " + (number * number));
        } catch (NumberFormatException e) {
            System.out.println("Entered input is not a valid format for an integer.");
        }
        sc.close();
    }
}