import java.util.*;

public class Common {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of data to be entered into first array :- ");
        String array1[] = new String[sc.nextInt()];
        System.out.println("Enter the values in to first array :- ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = sc.next();
        }
        System.out.print("The first array is :- [");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]);
            if (i != array1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");


        System.out.println("Enter the number of data to be entered into second array :- ");
        String array2[] = new String[sc.nextInt()];
        System.out.println("Enter the values in to second array :- ");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = sc.next();
        }
        System.out.print("The second array is :- [");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]);
            if (i != array2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");


        String array3[] = new String[((array1.length < array2.length) ? array1.length : array2.length)];
        int idx = 0;
        for (String s1 : array1) {
            for (String s2 : array2) {
                if (s1.equals(s2)) { 
                    array3[idx++] = s1;
                    break; 
                }
            }
        }
        System.out.print("The common elements are :- [");
        for (int i = 0; i < idx; i++) {
            System.out.print(array3[i]);
            if (i != idx - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}
