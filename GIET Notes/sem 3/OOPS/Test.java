/* import java.util.*;
public class Test {
    float a, b;
    Scanner sc = new Scanner(System.in);

    
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("Enter a number :- ");
        t.a = t.sc.nextFloat();
        String temp[] = new String[10];
        temp[0] = t.a+"";
        Rajesh.main(temp);
    }
}


class Rajesh{
    public static void main(String[] args) {
        System.out.println("Hii from Rajesh");
        new Rajesh().printing(Float.parseFloat(args[0]));
        
    }
    private void printing(float a1){
        System.out.println(a1);
        System.out.printf("%.2f\n",a1);

        int check = 1, val = 57;
        for(int i = 2; i <= (val/2); i++){
            if(val%2 == 0){
                check = 0;
                break;
            }
        }
        if(check == 1){
            System.out.println("It is prime");
        }else{
            System.out.println("It is not prime");
        }
    }
} */

public class Test{
    static int a = 9;
    public static void main(String[] args) {
        System.out.println(a);
    }
}