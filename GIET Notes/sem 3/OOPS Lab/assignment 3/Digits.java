public class Digits {

    public static void main(String[] args) {
        int val = 12345;
        System.out.print(val + " is displayed as " + (val/10000) + " ");
        val = val % 10000;
        System.out.print(val/1000 + " ");
        val = val % 1000;
        System.out.print(val/100 + " ");
        val = val % 100;
        System.out.print(val/10 + " ");
        val = val % 10;
        System.out.print(val);
    }
}