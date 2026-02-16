public class InnerClass {
    static class Inner {
        static void display() {
            System.out.println("Inside Inner Class");
        }
    }

    public static void main(String[] args) {
        InnerClass.Inner.display();
    }
}
