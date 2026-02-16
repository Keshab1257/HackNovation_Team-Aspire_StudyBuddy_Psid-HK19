import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AWT3 extends Frame implements ActionListener {
    TextField tf;

    AWT3(){
        tf = new TextField();
        tf.setBounds(20,50,80,20);

        Button b = new Button("Click me!");
        b.setBounds(20,70,80,20);

        b.addActionListener(this);

        add(tf);
        add(b);

        setSize(300,250);
        setTitle("AWT3 Example");
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        tf.setText("Hello World!");
    }

    public static void main(String[] args) {
        new AWT3();
    }
}
