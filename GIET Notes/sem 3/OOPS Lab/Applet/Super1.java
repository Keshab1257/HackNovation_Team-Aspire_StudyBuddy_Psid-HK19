class a{
    static void display(){
        System.out.println("In a display method");
    }
}
public class Super1{
    void show(){
        System.out.println("In show method");
        a.display();
    }
    public static void main(String[] args) {
        Super1 s = new Super1();
        s.show();
    }
}
