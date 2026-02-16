public class Quadratic {
    public static void main(String[] args) {
        int a = 15, b = 70, c = 30;
        int d = (b * b) - (4 * a * c); 

        if (d > 0) {
            System.out.println(d + " is a positive discriminant, so the equation has two real and distinct roots.");
            double res1 = (-b + Math.sqrt(d)) / (2.0 * a);
            double res2 = (-b - Math.sqrt(d)) / (2.0 * a);
            System.out.println("Roots are: " + res1 + " and " + res2);
        } else if (d < 0) {
            System.out.println(d + " is a negative discriminant, so the equation has complex roots.");
        } else {
            System.out.println(d + " is zero, so the equation has one real and equal root.");
            double res = (-b) / (2.0 * a);
            System.out.println("Root is: " + res);
        }
    }
}
