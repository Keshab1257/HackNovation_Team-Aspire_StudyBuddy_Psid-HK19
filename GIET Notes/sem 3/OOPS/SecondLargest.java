public class SecondLargest {
    public static void main(String[] args) {
        int arr[] = {1,20,6};
        int first, second;
        
        if ((first = arr[0]) < (second = arr[1])) { 
            int temp = first; 
            first = second; 
            second = temp; 
        }

        for(int i = 2; i < arr.length; i++){
            if(arr[i] > first){
                second = first;
                first = arr[i];
            }else if(arr[i] < first && arr[i] > second){
                second = arr[i];
            }
        }
        System.out.println(second);

        
    }
}
