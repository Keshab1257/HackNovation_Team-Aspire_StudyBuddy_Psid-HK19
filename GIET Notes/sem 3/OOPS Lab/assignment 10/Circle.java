import java.lang.*;
import java.io.*;
class Shape{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    float radius;
    void getPerimeter(){ }

    void getArea() { }
}

public class Circle extends Shape{
    void getPerimeter(){
        System.out.println("The perimeter of the circle is :- " + (2*3.14*radius));
    }

    void getArea(){
        System.out.println("The area of the circle is :- " + (3.14*radius*radius));
    }

    public static void main(String[] args) throws IOException{
        Circle c = new Circle();
        System.out.print("Enter the radius of the circle :- ");
        c.radius =Float.parseFloat(br.readLine());
        c.getPerimeter();
        c.getArea();
    }
}
