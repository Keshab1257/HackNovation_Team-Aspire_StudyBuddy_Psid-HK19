import java.lang.*;
import java.util.*;
public class IndexException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array:- ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements:-");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter an index to access:- ");
        int index = sc.nextInt();
        try {
            System.out.println("Element at index " + index + " is " + arr[index]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error :- ArrayIndexOutOfBoundsException");
        }
        sc.close();
    }
}
