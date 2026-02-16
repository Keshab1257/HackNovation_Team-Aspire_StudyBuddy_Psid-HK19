interface A{
    default void print(){
        System.out.println("Inside interface A");
    }
}

interface B{
    default void print(){
        System.out.println("Inside interface B");
    }
}

public class MultiInheritance implements A, B{
    public void print(){
        A.super.print();
        B.super.print();
        System.out.println("Inside class MultiInheritance");
    }
    public static void main(String args[]){
        MultiInheritance obj = new MultiInheritance();
        obj.print();
    }
}
