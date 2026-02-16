class Person {
    void displayPerson() {
        System.out.println("I am a Person");
    }
}

class Student extends Person {
    void displayStudent() {
        System.out.println("I am a Student");
    }
}

class GraduateStudent extends Student {
    void displayGraduate() {
        System.out.println("I am a Graduate Student");
    }
}

class Teacher extends Person {
    void displayTeacher() {
        System.out.println("I am a Teacher");
    }
}

public class Hybrid {
    public static void main(String[] args) {
        GraduateStudent gs = new GraduateStudent();
        gs.displayPerson();   
        gs.displayStudent();
        gs.displayGraduate(); 
        System.out.println();
        Teacher t = new Teacher();
        t.displayPerson();    
        t.displayTeacher();  
    }
}
