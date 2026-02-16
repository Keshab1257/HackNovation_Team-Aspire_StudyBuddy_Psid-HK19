import java.util.Scanner;
public class Test{
    public static void main(String[] args) {
        float []arr = new float[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 integer:- ");
        for(int i = 0; i < 10; i++){
            arr[i] = sc.nextInt();
        }
        for(float i : arr){
            System.out.print(i+", ");
        }
        sc.close();
    }
}