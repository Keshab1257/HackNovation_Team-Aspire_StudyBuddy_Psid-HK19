import java.lang.*;
class even extends Thread{
    public void run(){
        for(int i = 2; i<= 10; i+=2){
            System.out.println(i);
        }
    }
}

class odd extends Thread{
    public void run(){
        for(int i = 1;i <= 10; i+= 2){
            System.out.println(i);
        }
    }
}

public class Thread1{
    public static void main(String args[]){
        even t1 = new even();
        odd t2 = new odd();
        t1.start();
        t2.start();
    }
}