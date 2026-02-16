import java.lang.*;

class Vehicle {
    void drive() {
        System.out.println("Inside Vehicle class.");
    }
}

public class Car extends Vehicle {
    void drive() {
        System.out.println("Repairing a car.");
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.drive(); 
    }
}
