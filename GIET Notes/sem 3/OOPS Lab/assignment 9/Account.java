import java.lang.*;
import java.util.*;

public class Account {
    String accountNumber;
    float balance;
    
    Account(String a, float b){
        if(a == null || a == ""){
            System.out.println("Enter valid account number.");
            return;
        }

        if(b < 0){
            System.out.println("Balance cannot be negative.");
            return;
        }

        accountNumber = a;
        balance = b;
        display();
    }

    public void display(){
        System.out.println("\nAccount details:- ");
        System.out.println("Account Number:- " + accountNumber);
        System.out.println("Balance:- " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number:- ");
        String a = sc.nextLine();
        System.out.print("Enter balance:- ");
        float b = sc.nextFloat();
        Account acc = new Account(a, b);

        sc.close();
    }
}
