package lab2;

import javax.swing.*;
import java.awt.*;

// Tooltip
public class q4_b {
    JFrame frame;
    JLabel l1,l2;
    JTextField t1,t2;

    public q4_b() {
        frame = new JFrame("Tooltip");
        l1 = new JLabel("Name");
        l2 = new JLabel("Age");

        t1 = new JTextField(10);
        t2 = new JTextField(10);

        t1.setToolTipText("Enter your name");
        t2.setToolTipText("Enter your age");

        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        l1.setBounds(20, 10, 50, 30);
        t1.setBounds(150, 10, 100, 30);

        l2.setBounds(20, 80, 50, 30);
        t2.setBounds(150, 80, 100, 30);

        frame.add(l1);
        frame.add(t1);

        frame.add(l2);
        frame.add(t2);

    }
    public static void main(String[] args) {
        new q4_b();
    }
}
