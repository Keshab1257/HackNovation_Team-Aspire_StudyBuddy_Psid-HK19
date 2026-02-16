class thread extends Thread{
    int n = 0;
    public void run(){
        for(int i = 1; i <= 10; i++){
            n = n + 1;
        }
    }
}
public class ThreadCount {
    public static void main(String[] args) {
        thread t = new thread();
        t.start();
        try{
            t.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println(t.n);
    }
}


