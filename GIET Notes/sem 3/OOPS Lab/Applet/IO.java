import java.io.*;

class student implements Serializable{
    int roll;
    String name;
    student(int roll, String name){
        this.roll = roll;
        this.name = name;
    }
}
public class IO {
    public static void main(String[] args) {
        try{
            student s1 = new student(15,"Rajesh Rana!");
            student s2 = new student(06,"Subha !");
            FileOutputStream fr = new FileOutputStream("C:\\D\\GIET Notes\\sem 3\\OOPS Lab\\Applet\\File.txt");
            ObjectOutputStream out = new ObjectOutputStream(fr);
            out.writeObject(s1);
            out.writeObject(s2);
            out.flush();
            out.close();

            FileInputStream fi = new FileInputStream("C:\\D\\GIET Notes\\sem 3\\OOPS Lab\\Applet\\File.txt");
            ObjectInputStream in = new ObjectInputStream(fi);
            student output1 = (student)in.readObject();
            System.out.println(output1.roll+" "+ output1.name);
            student output2 = (student)in.readObject();
            System.out.println(output2.roll+" "+ output2.name);
        }
        catch(Exception e){

        }
    }
}
