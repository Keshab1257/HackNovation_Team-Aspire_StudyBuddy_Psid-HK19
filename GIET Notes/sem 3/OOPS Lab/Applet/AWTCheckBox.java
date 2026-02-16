import java.awt.*;
import java.awt.event.*;
public class AWTCheckBox {
    Label l1, l2;
    AWTCheckBox(){
        Frame f = new Frame("AWT check Box Example");

        CheckboxGroup chg = new CheckboxGroup();

        l1 = new Label();
        l1.setBounds(50, 50, 200, 20);

        l2 = new Label();
        l2.setBounds(50, 80, 200, 20);

        Checkbox ch1 = new Checkbox("C++",chg,false);
        ch1.setBounds(20, 50, 100, 20);

        Checkbox ch2 = new Checkbox("Java",chg,false);
        ch2.setBounds(20, 80, 100, 20);

        ch1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                l1.setText("C++ is " + ((e.getStateChange() == 1)?"Checked":"Un-Checked"));
                l2.setText("Java is " + ((e.getStateChange() != 1)?"Checked":"Un-Checked"));
            }
        });

        ch2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                l2.setText("Java is " + ((e.getStateChange() == 1)?"Checked":"Un-Checked"));
                l1.setText("C++ is " + ((e.getStateChange() != 1)?"Checked":"Un-Checked"));
            }
        });

        f.add(l1);
        f.add(l2);
        f.add(ch1);
        f.add(ch2);

        f.setSize(300,250);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new AWTCheckBox();
    }
}
