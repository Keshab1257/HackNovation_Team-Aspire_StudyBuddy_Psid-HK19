import java.lang.*;
import java.util.*;

public class Shape{
    int length, breadth, temp;

    public void area(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
        int area = this.length * this.breadth;
        System.out.println("Area of Rectangle:- " + area + "\n");
    }

    public void area(int side){
        length = side;
        int area = length * length;
        System.out.println("Area of Square:- " + area + "\n");
    }

    public void area(int a, int b, int c){
        length = a;
        breadth = b;
        temp = c;
        int s = (length + breadth + temp) / 2;
        int area = (int)Math.sqrt(s * (s - length) * (s - breadth) * (s - temp));
        System.out.println("Area of scalene Triangle is :- " + area);
        
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Shape obj = new Shape();

        System.out.print("Enter the length of Rectangle:- ");
        int l = sc.nextInt();
        System.out.print("Enter the breadth of Rectangle:- ");
        int b = sc.nextInt();
        obj.area(l,b);

        System.out.print("Enter the side of Square:- ");
        l = sc.nextInt();
        obj.area(l);

        System.out.print("Enter side 'a' of scalene Triangle:- ");
        l = sc.nextInt();
        System.out.print("Enter side 'b':- ");
        b = sc.nextInt();
        System.out.print("Enter side 'c':- ");
        int c = sc.nextInt();
        obj.area(l,b,c);

        sc.close();
    }
}