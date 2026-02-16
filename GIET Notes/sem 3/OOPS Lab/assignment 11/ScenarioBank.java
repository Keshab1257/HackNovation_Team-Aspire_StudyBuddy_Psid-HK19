import java.lang.*;
import java.util.*;

abstract class Bank {
    abstract double getROI();
}

class SBI extends Bank {
    double getROI() {
        return 8.4;
    }
}

class ICICI extends Bank {
    double getROI() {
        return 7.3;
    }
}

class AXIS extends Bank {
    double getROI() {
        return 9.7;
    }
}

public class ScenarioBank {
    static double principal, years;
    static int n;
    static void calCI(String bank, double rate) {
        double amount = principal * Math.pow((1 + rate / (100 * n)), n * years);
        System.out.printf("%s :- %.2f\n", bank, amount);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter principal amount :- ");
        principal = sc.nextDouble();
        System.out.print("Enter number of years :- ");
        years = sc.nextDouble();
        System.out.print("Enter number of times interest is compounded per year :- ");
        n = sc.nextInt();

        System.out.println("\nReturn amounts from different banks (Compound Interest) :- ");
        SBI s = new SBI();
        calCI("SBI", s.getROI());
        ICICI i = new ICICI();
        calCI("ICICI", i.getROI());
        AXIS a = new AXIS();
        calCI("AXIS", a.getROI());

        sc.close(); 
    }
    
}
