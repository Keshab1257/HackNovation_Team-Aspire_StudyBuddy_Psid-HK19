public class BMI {
    public static void main(String[] args) {
        float kg = 73.0f;
        float meter = 1.2f;
        float bmi = kg/(meter * meter);
        System.out.println("The BMI is " + bmi + " kg/m^2");
    }
}
