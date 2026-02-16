import java.lang.*;
public class SumOfNOddNumber {
    public static void main(String[] args) {
        int terms = 5;
        int sum = 0;
        System.out.println("The odd numbers are :- ");
        for (int i = 1; i <= terms*2; i++) {
            if(i%2 != 0){
                System.out.println(i + " ");
                sum += i;
            }
        }
        System.out.println("The sum of odd natural numbers upto 5 terms is : " + sum);
    }    
}
