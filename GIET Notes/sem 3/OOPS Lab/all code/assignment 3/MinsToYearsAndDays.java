public class MinsToYearsAndDays {
    public static void main(String[] args) {
        int mins = 3456789;
        int years = mins / (365 * 24 * 60);
        int days = (mins % (365 * 24 * 60)) / (24 * 60);
        System.out.print(mins + " minutes is approximately: ");
        System.out.print(years + " years and " + days + " days.");
    }
}
