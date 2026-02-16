import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int a = Integer.parseInt(br.readLine());
            System.out.println(a);
        } catch (IOException e) {
            System.out.println("IOException occurred while reading input");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer");
        }
    }
}
