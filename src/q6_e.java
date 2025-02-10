import javax.swing.*;
import java.awt.*;

public class q6_e {
    JFrame frame;
    JButton b1, b2, b3, b4;

    public q6_e() {
        frame = new JFrame("Box Layout Example");
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new q6_e();
    }
}
