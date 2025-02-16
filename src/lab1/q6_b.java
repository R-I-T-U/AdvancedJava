package lab1;

import javax.swing.*;
import java.awt.*;

public class q6_b {
    JFrame frame;
    JButton b1, b2, b3, b4, b5;
    public q6_b() {
        frame = new JFrame("BorderLayout");
        b1 = new JButton("b1");
        b2 = new JButton("b2");
        b3 = new JButton("b3");
        b4 = new JButton("b4");
        b5 = new JButton("b5");

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2, BorderLayout.SOUTH);
        frame.add(b3, BorderLayout.EAST);
        frame.add(b4, BorderLayout.WEST);
        frame.add(b5, BorderLayout.CENTER);

    }
    public static void main(String[] args) {
        new q6_b();
    }
}
