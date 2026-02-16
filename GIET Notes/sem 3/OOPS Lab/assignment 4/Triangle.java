import java.lang.*;
public class Triangle {
    public static void main(String[] args) {
        int last = 10 ;
        int row = 0; 
        int count = 0;
        System.out.println("The pattern is :- ");
        for (int i = 1; i <= last; i++) {
            System.out.print(i + " ");
            count++;
            if(count > row){
                row++;
                count = 0;
                System.out.println();
            }
        }
   }    
}
