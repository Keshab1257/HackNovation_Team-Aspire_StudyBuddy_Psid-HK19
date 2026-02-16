import java.lang.*;

class AgeException extends RuntimeException{
    AgeException(){
        super("Age is below 18 years!");
    }
}

public class Exception1 {
    public static void main(String[] args) {
        int age = 17;
        try{
            if(age < 18){
                throw new AgeException();
            }
        }catch(AgeException e){
            System.out.println("Inside Age exception");
            System.out.println(e.getMessage());        
        }
        System.out.println("Completed");
    }
}
