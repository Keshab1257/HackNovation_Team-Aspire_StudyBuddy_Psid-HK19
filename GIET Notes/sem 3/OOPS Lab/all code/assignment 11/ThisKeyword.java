public class ThisKeyword {
    String name;
    int age;
    ThisKeyword(String name, int age) {
        this.name = name;  
        this.age = age;
        this.display();   
    }

    void display() {
        System.out.println("Name:- " + name + ", Age:- " + age);
    }

    ThisKeyword() {
        this("Unknown", 0);  
    }
    public static void main(String[] args) {
        ThisKeyword s1 = new ThisKeyword();

        ThisKeyword s2 = new ThisKeyword("Rajesh", 20);
    }
}
