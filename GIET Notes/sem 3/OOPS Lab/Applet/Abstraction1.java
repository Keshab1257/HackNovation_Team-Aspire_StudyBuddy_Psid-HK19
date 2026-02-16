class person{
    void walk(){
        System.out.println("person is walking");
    }
}

public class Abstraction1 {
    public static void main (String[] args) {
        person p = new person(){
        };
        p.walk();
    }
}
