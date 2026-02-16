import java.lang.*;
import java.io.*;
public class Armstrong {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number :- ");
        int val = Integer.parseInt(br.readLine());
        int count = 0, temp = val;
        while(temp != 0){
            count++;
            temp = temp / 10;
        }
        temp = val;
        int sum = 0;
        while (temp != 0) {
            sum += Math.pow((temp % 10), count);
            temp = temp / 10;
        }
        if(val == sum){
            System.out.println(val + " is an Armstrong number.");
        }
        else{
            System.out.println(val + " is not an Armstrong number.");
        }
    }
}
