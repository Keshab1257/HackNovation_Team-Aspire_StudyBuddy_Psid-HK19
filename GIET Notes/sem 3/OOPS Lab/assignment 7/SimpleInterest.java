import java.lang.*;
import java.util.*;

public class SimpleInterest {
    float principal, rate = 7.5F, time;

    public void calculateSI() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal Amount:- ");
        principal = sc.nextFloat();
        System.out.print("Enter Time in Years:- ");
        time = sc.nextFloat();
        System.out.println("Simple Interest = " + ((principal * rate * time) / 100));
        sc.close();
    }
    public static void main(String[] args) {
        SimpleInterest si = new SimpleInterest();
        si.calculateSI();
    }
}
