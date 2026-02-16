public class SumOfAllDigits {
    public static void main(String[] args) {
        int val = 519;
        int temp = val;
        int sum = 0;
        sum += (temp%10);
        temp = temp/10;
        sum += (temp%10);
        temp = temp/10;
        sum += temp;

        System.out.println("The sum of all the digits of " + val + " is :- " + sum);
    }
    
}