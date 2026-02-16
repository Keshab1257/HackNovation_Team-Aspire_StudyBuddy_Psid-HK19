import java.lang.*;
public class Month {
    public static void main(String[] args) {
        int month = 2;
        switch (month) {
            case 1:
                System.out.println("It is January");
                break;
            case 2:
                System.out.println("It is February");
                break;
            case 3:
                System.out.println("It is March");
                break;
            case 4:
                System.out.println("It is April");
                break;
            case 5:
                System.out.println("It is May");
                break;
            case 6:
                System.out.println("It is June");
                break;
            case 7:
                System.out.println("It is July");
                break;
            case 8:
                System.out.println("It is August");
                break;
            case 9:
                System.out.println("It is September");
                break;
            case 10:
                System.out.println("It is October");  
                break;
            case 11:
                System.out.println("It is November"); 
                break;
            case 12:
                System.out.println("It is December"); 
                break;        
            default:
                System.out.println("Enter a valid month");
                break;
        }
    }
}
