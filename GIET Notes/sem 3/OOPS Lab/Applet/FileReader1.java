import java.io.FileInputStream;

public class FileReader1 {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C:\\D\\GIET Notes\\sem 3\\OOPS Lab\\Applet\\File.txt");
            int data;
            while ((data = fin.read()) != -1) {
                System.out.print((char) data);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
