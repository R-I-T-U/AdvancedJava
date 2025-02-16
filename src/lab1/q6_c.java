package lab1;

import javax.swing.*;
import java.awt.*;

public class q6_c {
    JFrame frame;
    JButton b1, b2, b3, b4;
    public q6_c() {
        frame = new JFrame("GridLayout");
        b1 = new JButton("b1");
        b2 = new JButton("b2");
        b3 = new JButton("b3");
        b4 = new JButton("b4");

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2));
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
    }
    public static void main(String[] args) {
        new q6_c();
    }
}
