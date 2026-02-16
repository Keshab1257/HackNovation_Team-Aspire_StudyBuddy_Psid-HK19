abstract class person{
    abstract void eat();
}

public class InnerClass2{
    public static void main(String[] args) {
        person p = new person();
        p.eat();
    }
}