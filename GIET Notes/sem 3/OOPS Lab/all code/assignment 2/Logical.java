import java.lang.*;
public class Logical{
    public static void main(String[] args) {
        int x = 50, y = -5;
        boolean a = (x > 0);
        boolean b = (y > 0);

        System.out.println("a && b (AND): " + (a && b));
        System.out.println("a || b (OR): " + (a || b));
        System.out.println("!a (NOT a): " + (!a));
        System.out.println("!b (NOT b): " + (!b));
        System.out.println("a ^ b (XOR): " + (a ^ b)); 
    }
}