package lab2;

import javax.swing.*;
import java.awt.*;

// Tooltip
public class q4_b {
    JFrame frame;
    JTextArea text;

    public q4_b() {
        frame = new JFrame();
        text = new JTextArea(10,10);

        frame.add(text);
        text.setToolTipText("Write your opinions here.");

        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

    }
    public static void main(String[] args) {
        new q4_b();
    }
}
