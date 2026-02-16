import java.util.*;
public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of data to be entered into te array :- ");
        int arr[] = new int[sc.nextInt()];
        System.out.println("Enter the values in to the array :- ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("The Original array is :- [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.print("Sorted array (Insertion Sort) :- [");
        int j, temp;
        for(int i = 0; i < arr.length; i++){
            j = i-1;
            temp = arr[i];
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}
