import java.io.*;
public class Duplicate {
    public static void main(String[] args) throws IOException{
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

        int dupArr[] = new int[arr.length];
        int idx = 0;

        for(int i = 0; i < arr.length; i++){
            boolean flag = false;
            for(int j = 0; j < idx; j++){
                if(arr[i] == dupArr[j]){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            for(int k = i+1; k < arr.length; k++){
                if(arr[i] == arr[k]){
                    dupArr[idx++] = arr[i];
                    break;
                }
            }
        }

        int j, temp;
        for(int i = 0; i < idx; i++){
            j = i-1;
            temp = dupArr[i];
            while(j >= 0 && dupArr[j] > temp){
                dupArr[j+1] = dupArr[j];
                j--;
            }
            dupArr[j+1] = temp;
        }

        if (idx == 0) {
            System.out.println("No duplicate elements found.");
        } else {
            for (int i = 0; i < idx; i++) {
                System.out.println("Duplicate Element : " + dupArr[i]);
            }
        }
    }
}
