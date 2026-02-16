public class Speed {
    public static void main(String[] args) {
        int dist = 200000;
        int hour = 20;
        int min = 60;
        int sec = 200;
        float hours = (hour+(min/60) + (sec/(60*60))) ;
        float seconds = ((hour*60*60) + (min*60) + sec);
        float km = dist/1000;
        float speedMS = dist/seconds;
        float speedKMPH = km/hours;

        System.out.println("The speed in meter per second is " + speedMS);
        System.out.println("The speed in km per hour is " + speedKMPH);
    }
}
