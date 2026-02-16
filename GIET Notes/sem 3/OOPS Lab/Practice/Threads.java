class Demo extends Thread{
    public void run(){
        for(int i = 1; i <= 10; i++){
            if(i == 6){
                try{
                    Thread.sleep(5000);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            System.out.println(i);
        }
    }
}

public class Threads {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.start();
    }
}
