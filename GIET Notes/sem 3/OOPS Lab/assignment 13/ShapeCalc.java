import java.lang.*;
import java.util.*;
import Rajesh.shape.Rectangle;
import Rajesh.shape.Square;

public class ShapeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle rect = new Rectangle();
        Square sq = new Square();
        System.out.print("Enter length of the rectangle :- ");
        int l = sc.nextInt();
        System.out.print("Enter breadth of the rectangle :- ");
        int b = sc.nextInt();
        System.out.println("Area of Rectangle:- " + rect.area(l, b));
        System.out.println("Perimeter of Rectangle:- " + rect.perimeter(l, b));

        System.out.print("\nEnter side of square:- ");
        int s = sc.nextInt();
        System.out.println("Area of Square:- " + sq.area(s));
        System.out.println("Perimeter of Square:- " + sq.perimeter(s));
        sc.close();
    }    
}
