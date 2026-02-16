import java.lang.*;
import java.util.*;
class Vehicle{
    static Scanner sc = new Scanner(System.in);
    String make, model, fuelType;
    int year;
    void fuelEfficiency(float dist, float fuel) { }
    void maxSpeed() { }
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

public class Main2 extends Vehicle {
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
        String arr[] = {"Truck", "car", "Motor Cycle"};
        int count = 0;

        Vehicle v[] = {new Truck(), new Car(), new MotorCycle()};
        for(Vehicle ve : v){
            input(ve, arr[count]);
            display(ve, arr[count]);
            ve.fuelEfficiency(dist,fuel);
            ve.maxSpeed();
            Vehicle.sc.nextLine();
        }

        sc.close();
    }
}
