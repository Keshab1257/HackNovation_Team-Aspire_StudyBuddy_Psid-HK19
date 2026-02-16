import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of data to be entered into te array :- ");
        int arr[] = new int[sc.nextInt()];
        System.out.println("Enter the values into the array :- ");
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

        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        int average = sum/arr.length;

        System.out.println("The average of array elements is " + average);
        sc.close();
    }
}
