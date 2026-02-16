import java.lang.*;
import java.util.Scanner;

public class Area {

    public static void areaOfRectangle(Scanner sc) {
        System.out.print("Enter length of rectangle:- ");
        int length = sc.nextInt();
        System.out.print("Enter breadth of rectangle:- ");
        int breadth = sc.nextInt();
        System.out.println("Area of rectangle = " + (length * breadth));
    }

    public void areaOfSquare(Scanner sc) {
        System.out.print("\nEnter side of square:- ");
        int side = sc.nextInt();
        System.out.println("Area of Square = " + (side * side));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Area area = new Area();
        areaOfRectangle(sc);
        area.areaOfSquare(sc);
        sc.close();
    }
}
