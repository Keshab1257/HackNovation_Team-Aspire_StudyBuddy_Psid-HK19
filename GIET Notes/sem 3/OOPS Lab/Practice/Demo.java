class a {
    int a1;
}

class Demo extends a {
    int a1 = 5;   // hides parent's a1

    void input() {
        a1 = 10;  // modifies Demo's a1
    }

    void show() {
        System.out.println("In class a");
    }

    static void display() {
        System.out.println("In class Demo");
    }

    public static void main(String[] args) {
        a d = new Demo();
        d.input();
        d.show();
        System.out.println(d.a1);
    }
}
