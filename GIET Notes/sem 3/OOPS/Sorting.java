public class Sorting{
    public static void main(String[] args) {
        int arr[] = {5,31,4,2,8};
        int j, temp;
        for(int i = 1; i < arr.length; i++){
            j = i-1;
            temp = arr[i];
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i < arr.length-1){
                System.out.print(", ");
            }
        }
    }
}