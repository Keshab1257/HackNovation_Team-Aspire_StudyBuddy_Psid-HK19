import java.awt.*;
public class AWT2 {
    AWT2(){
        Frame f = new Frame();
        Label l = new Label("Enter a number :- ");
        Button b = new Button("Submit");
        TextArea t = new TextArea();

        l.setBounds(20,80,80,30);
        t.setBounds(20,100,80,30);
        b.setBounds(100,100,80,30);

        f.add(l);
        f.add(t);
        f.add(b);

        
        f.setSize(400, 250);
        f.setTitle("Second AWT Example");
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        AWT2 e = new AWT2();
    }
}
