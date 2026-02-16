import javax.swing.*;
import java.awt.*;

public class Paint extends JFrame {

    public Paint() {
        setTitle("Demo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Welcome", 150, 150);
    }

    public static void main(String[] args) {
        new Paint();
    }
}
