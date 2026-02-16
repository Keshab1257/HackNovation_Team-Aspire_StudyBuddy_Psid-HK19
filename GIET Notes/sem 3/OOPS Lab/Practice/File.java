import java.io.*;
public class File
{
	public static void main(String[] args)throws IOException {
	    FileReader fr = new FileReader("New.txt");
	    FileWriter fo = new FileWriter("New2.txt");
        byte b[] = fr.read().getBytes();
        fo.write(b);
        fr.close();
        fo.close();
	}
}
