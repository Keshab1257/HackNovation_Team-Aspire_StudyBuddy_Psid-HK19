import java.lang.*;
import java.util.*;
class BankAccount {
    static Scanner sc = new Scanner(System.in);
    String accno, accName;
    float initialBalance;

    void deposit() {
        System.out.print("\nEnter the amount to be deposited:- ");
        initialBalance += sc.nextFloat();
        System.out.println("Final Balance is:- " + initialBalance);
    }

    void withdraw() { }  
}

public class SavingsAccount extends BankAccount {

    SavingsAccount(String accno, String accName, float initialBalance) {
        this.accno = accno;
        this.accName = accName;
        this.initialBalance = initialBalance;
    }

    void withdraw() {
        if (initialBalance < 100) {
            System.out.println("\nYou cannot withdraw money because the balance is less than Rs. 100.");
            return;
        }
        System.out.print("\nEnter the amount to withdraw:- ");
        float amount = sc.nextFloat();

        if (initialBalance - amount < 100) {
            System.out.println("Withdrawal failed as the balance would fall below Rs. 100.");
        } else {
            initialBalance -= amount;
            System.out.println("Withdrawal of Rs. " + amount + " is successful.");
            System.out.println("Final Balance is:- " + initialBalance);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the account number:- ");
        String accno = sc.nextLine();

        System.out.print("Enter the account holder's name:- ");
        String accName = sc.nextLine();

        System.out.print("Enter the initial balance:- ");
        float initialBalance = sc.nextFloat();

        SavingsAccount sa = new SavingsAccount(accno, accName, initialBalance);

        System.out.println("\nAccount Details :- ");
        System.out.println("Account Number :- " + sa.accno);
        System.out.println("Account Name   :- " + sa.accName);
        System.out.println("Balance        :- " + sa.initialBalance);

        sa.deposit();
        sa.withdraw();

        sc.close();
    }
}