import java.lang.*;
public class Main5 {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("Before swapping :-");
        System.out.println("a = " + a + ", b = " + b);

        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping :-");
        System.out.println("a = " + a + ", b = " + b);
    }    
}
