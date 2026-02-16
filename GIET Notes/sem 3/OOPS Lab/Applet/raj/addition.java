package raj;


abstract class subtraction {
    public void sub(){
        System.out.println("Inside subtraction method");
    }
}
public class addition extends subtraction {
    public void add(){
        System.out.println("Inside addition method");
    }
}
