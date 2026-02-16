import java.io.*;
public class MaxAndMin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of data to be entered into te array :- ");
        int arr[] = new int[Integer.parseInt(br.readLine())];
        System.out.println("Enter the values into the array :- ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.print("The Original array is :- [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int min = arr[0], max = arr[0];
        for(int i : arr){
            if(i > max) max = i;
            if(i < min) min = i;
        }
        System.out.println("Maximum value for the above array = " + max);
        System.out.println("Minimum value for the above array = " + min);
    }
}
