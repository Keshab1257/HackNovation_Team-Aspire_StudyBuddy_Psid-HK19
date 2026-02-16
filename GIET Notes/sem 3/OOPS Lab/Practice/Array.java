public class Array {
    public static void main(String[] args) {
        int [] arr = new int[5];
        String b = args[5];
        for(int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(args[i]);
        }
        for(int i : arr){
            System.out.print(i+", ");
        }
        System.out.println(b);
    }
}
