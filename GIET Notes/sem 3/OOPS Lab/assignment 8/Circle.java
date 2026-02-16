import java.lang.*;
import java.util.*;
public class Circle {
    float radius;

    Circle(int r){
        radius = r;
    }

    public void area(){
        
        System.out.printf("Area:- %.2f\n",(3.14 * radius * radius));
    }

    public void circumference(){
        System.out.printf("Circumference:- %.2f\n\n",(2 * 3.14 * radius));
    }

    public void setRadius(int r){
        radius = r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle :- ");
        Circle c = new Circle(sc.nextInt());
        c.area();
        c.circumference();
        System.out.print("Enter the new radius of the circle :- ");
        c.setRadius(sc.nextInt());
        c.area();
        c.circumference();
        sc.close();
    }
}
