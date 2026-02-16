import java.awt.*;
import java.awt.event.*;

public class AWTChoiceExample {
    AWTChoiceExample() {
        Frame f = new Frame("Choice Example");

        Label l = new Label("Select a language:");
        l.setBounds(20, 50, 120, 30);

        Choice ch = new Choice();
        ch.add("C");
        ch.add("C++");
        ch.add("Java");
        ch.add("Python");
        ch.add("JavaScript");
        ch.setBounds(150, 50, 120, 30);

        TextField t = new TextField();
        t.setBounds(20, 120, 250, 30);

        Button b = new Button("Show Choice");
        b.setBounds(20, 170, 100, 30);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("You selected: " +ch.getItem(ch.getSelectedIndex()));
            }
        });

        f.add(l);
        f.add(ch);
        f.add(t);
        f.add(b);

        f.setSize(350, 250);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new AWTChoiceExample();
    }
}
