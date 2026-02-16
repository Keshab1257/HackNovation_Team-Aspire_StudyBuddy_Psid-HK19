import java.lang.*;
import java.util.*;

class Char{
    char c;
    int idxs[];
    int i = 1;
    Char(char c, int len, int idxs){
        this.c = c;
        this.idxs = new int[len];
        this.idxs[0] = idxs;
    }
    void addIdx(int idx){
        this.idxs[i++] = idx;
    }
}

public class IndexOfCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string :- ");
        String str = sc.nextLine();
        
        Char[] cha = new Char[str.length()];
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean found = false;

            for (int j = 0; j < idx; j++) {
                if (cha[j].c == c) {
                    cha[j].addIdx(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                int k = idx - 1;
                while (k >= 0 && cha[k].c > c) {
                    cha[k + 1] = cha[k];
                    k--;
                }
                cha[k + 1] = new Char(c, str.length(), i);
                idx++;  
            }
        }
        System.out.println("Character indices :-\n");
        System.out.println("\033[1mChar | Freq | Indices\033[0m"); 
        for(int i = 0; i < idx; i++){
            System.out.print(cha[i].c + "    |  "+ cha[i].i + "   |  ");
            for(int j = 0; j < cha[i].i; j++){
                System.out.print(cha[i].idxs[j] + " ");
            }
            System.out.println();
        }
        
    }
}
