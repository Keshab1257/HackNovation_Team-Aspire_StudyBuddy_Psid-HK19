import java.lang.*;
import java.util.*;

public class Point {
    double x, y;

    Point(int a, int b) {
        x = a;
        y = b;
        System.out.printf("int constructor :- (%.0f, %.0f)\n", x,y);
    }

    Point(double a, double b) {
        x = a;
        y = b;
        System.out.println("double constructor :- (" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x (int) :- ");
        int a = sc.nextInt();
        System.out.print("Enter y (int) :- ");
        int b = sc.nextInt();
        Point p1 = new Point(a, b);

        System.out.print("Enter x (double) :- ");
        double c = sc.nextDouble();
        System.out.print("Enter y (double) :- ");
        double d = sc.nextDouble();
        Point p2 = new Point(c, d);

        sc.close();
    }
}
