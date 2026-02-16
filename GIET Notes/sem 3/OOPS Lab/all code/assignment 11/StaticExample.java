public class StaticExample {
    String name;
    int age;
    static int studentCount = 0;

    StaticExample(String name, int age) {
        this.name = name;
        this.age = age;
        studentCount++; 
        showDetails();
    }

    static void displayCount() {
        System.out.println("Total students created: " + studentCount);
    }

    static {
        System.out.println("Inside static block.");
    }

    void showDetails() {
        System.out.println("Name:- " + name + ", Age:- " + age);
    }
    public static void main(String[] args) {
        StaticExample s1 = new StaticExample("Rajesh", 20);
        StaticExample s2 = new StaticExample("Subha", 19);
        displayCount();
    }
}
