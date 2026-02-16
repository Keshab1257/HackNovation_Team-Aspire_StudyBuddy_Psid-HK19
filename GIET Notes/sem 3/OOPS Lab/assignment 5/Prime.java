import java.lang.*;
import java.util.*;
public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :- ");
        int val = sc.nextInt();
        int check = 1;
        for(int i = 2; i <= (val/2); i++){
            if(val%i == 0){
                check = 0;
                break;
            }
        }
        if(check == 1){
            System.out.println(val + " is a prime number.");
        }
        else{
            System.out.println(val + " is not a prime number.");
        }
    }    
}
