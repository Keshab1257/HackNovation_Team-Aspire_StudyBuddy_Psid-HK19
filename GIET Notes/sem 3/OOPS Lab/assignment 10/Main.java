import java.lang.*;
import java.util.*;
class Vehicle{
    static Scanner sc = new Scanner(System.in);
    String make, model, fuelType;
    int year;
}

class Truck extends Vehicle{
    void fuelEfficiency(float dist, float fuel) {
        float eff = dist / fuel;
        System.out.println("The fuel efficiency of the truck is :- " + eff + " km/l");
    }

    void maxSpeed() {
        System.out.println("The maximum speed of truck is 150 Km/hr.\n\n");
    }
}

class Car extends Vehicle{
    void fuelEfficiency(float dist, float fuel) {
        float eff = dist / fuel;
        System.out.println("The fuel efficiency of the car is :- " + eff + " km/l");
    }

    void maxSpeed() {
        System.out.println("The maximum speed of car is 380 Km/hr.\n\n");
    }
}

class MotorCycle extends Vehicle{
    void fuelEfficiency(float dist, float fuel) {
        float eff = dist / fuel;
        System.out.println("The fuel efficiency of the motorcycle is :- " + eff + " km/l");
    }

    void maxSpeed() {
        System.out.println("The maximum speed of motorcycle is 250 Km/hr.\n\n");
    }
}

public class Main extends Vehicle {
    static float dist, fuel;
    static void input(Vehicle v, String veName){
        System.out.println("Enter " + veName + " details :- ");
        System.out.print("  Enter the make (Bharat Stage) :- ");
        v.make = sc.nextLine();
        System.out.print("  Enter the model :- ");
        v.model = sc.nextLine();
        System.out.print("  Enter the fuel type :- ");
        v.fuelType = sc.nextLine();
        System.out.print("  Enter the year of manufacturing :- ");
        v.year = sc.nextInt();            
        System.out.print("  Enter the distance traveled :- ");
        dist = sc.nextFloat();
        System.out.print("  Enter the fuel consumed :- ");
        fuel = sc.nextFloat();  
        sc.nextLine();
    }

    static void display(Vehicle v, String veName){
        System.out.println("\n" + veName + " details :- ");
        System.out.println("Make (Bharat Stage) :- " + v.make);
        System.out.println("Model :- " + v.model);
        System.out.println("Fuel Type :- " + v.fuelType);
        System.out.println("Year of manufacturing :- " + v.year);
    }
    public static void main(String[] args) {
        Truck t = new Truck();
        input(t, "Truck");
        display(t,"Truck");
        t.fuelEfficiency(dist, fuel);
        t.maxSpeed();

        Car c = new Car();
        input(c, "Car");
        display(c,"Car");
        c.fuelEfficiency(dist, fuel);
        c.maxSpeed();

        MotorCycle m = new MotorCycle();
        input(m, "Motor Cycle");
        display(m,"Motor Cycle");
        m.fuelEfficiency(dist, fuel);
        m.maxSpeed();

        sc.close();
    }
}
