class print{
    synchronized static void display(int n){
        for(int i = n; i <= 10; i+=2){
            System.out.println(i);
        }
    }
}

class EvenThread extends Thread{
    public void run(){
        System.out.println("Even Numbers:");
        print.display(2);
    }
}

class OddThread extends Thread{
    public void run(){
        System.out.println("Odd Numbers:");
        print.display(1);
    }
}

public class EvenOddThread {
    public static void main(String[] args) {
        EvenThread t1 = new EvenThread();
        OddThread t2 = new OddThread();
        t1.start();
        try{
            t1.join();
        }
        catch(Exception e){
            System.out.println(e);
        } 
        t2.start();
    }
}
