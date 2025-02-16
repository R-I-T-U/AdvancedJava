package lab1;

import javax.swing.*;
import java.awt.*;

//wajp using swing component to demonstrate the concept of following layout manager.
// a. FlowLayout b. BorderLayout c. GridLayout d. GridbagLayout e. BoxLayout and CardLayout
public class q6_a {
    JFrame frame;
    JButton b1, b2, b3, b4;
    public q6_a() {
        frame = new JFrame("FlowLayout");
       b1 = new JButton("b1");
       b2 = new JButton("b2");
       b3 = new JButton("b3");
       b4 = new JButton("b4");

       frame.setSize(300, 300);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(new FlowLayout());
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
    }
    public static void main(String[] args) {
        new q6_a();
    }
}
