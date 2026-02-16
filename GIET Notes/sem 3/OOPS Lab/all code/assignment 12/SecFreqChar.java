import java.lang.*;
import java.util.*;

public class SecFreqChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string :- ");
        String str = sc.nextLine();

        char[] cha = new char[str.length()];
        int[] freq = new int[str.length()];
        int idx = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean found = false;

            for (int j = 0; j < idx; j++) {
                if (cha[j] == c) {
                    freq[j]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                cha[idx] = c;
                freq[idx] = 1;
                idx++;
            }
        }

        int first = 0, second = 0;
        for (int i = 0; i < idx; i++) {
            if (freq[i] > first) {
                second = first;
                first = freq[i];
            } else if (freq[i] > second && freq[i] != first) {
                second = freq[i];
            }
        }

        if(second == 0) {
            System.out.println("No second most frequent character.");
            sc.close();
            return;
        }
        System.out.print("Second most frequent character :- ");
        for (int i = 0; i < idx; i++) {
            if (freq[i] == second) {
                System.out.print(cha[i] + ", ");
            }
        }

        sc.close();
    }
}
