import java.lang.*;
import java.util.*;
public class Rectangle {
    int width, height;

    Rectangle(int w, int h){
        width = w;
        height = h;
    }

    public void area(){
        System.out.println("Area:- " + (width * height));
    }

    public void perimerter(){
        System.out.println("Perimeter:- " + (2*(width + height)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width of the rectangle :- ");
        int width = sc.nextInt();
        System.out.print("Enter the height of the rectangle :- ");    
        int height = sc.nextInt(); 
        Rectangle r = new Rectangle(width, height);
        r.area();
        r.perimerter();
        sc.close();
    }
}
