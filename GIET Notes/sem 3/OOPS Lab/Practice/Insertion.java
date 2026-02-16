public class Insertion {
    public static void main(String[] args) {
        String str = "Hii is there";

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                System.out.print("*");
            }else{
                System.out.print(str.charAt(i));
            }
        }
    }
}
