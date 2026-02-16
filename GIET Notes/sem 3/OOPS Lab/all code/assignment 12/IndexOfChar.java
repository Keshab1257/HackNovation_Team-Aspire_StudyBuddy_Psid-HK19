import java.lang.*;
import java.util.*;

class IndexOfChar{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string :- ");
        String str = sc.nextLine();
        int cha[] = new int[str.length()];
        int freq[] = new int[str.length()];
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
                int k = idx - 1;
                while (k >= 0 && cha[k] > c) {
                    cha[k + 1] = cha[k];
                    freq[k + 1] = freq[k];
                    k--;
                }
                cha[k + 1] = c;
                freq[k + 1] = 1;
                idx++;
            }
        }

        System.out.println("Character frequencies :- ");
        for(int i = 0; i < idx; i++){
            System.out.println((char)cha[i] + ": " + freq[i]);
        }
        sc.close();
    }
}