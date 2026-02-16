import java.util.*;
public class PyramidPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of layers to print :- ");
        int layer = sc.nextInt();
        
        for(int i = 0 ; i < layer; i++){
            for(int j = 0; j < (layer-i)-1; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < 2*i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
