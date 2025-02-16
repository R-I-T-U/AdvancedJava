package lab1;

import javax.swing.*;
import java.awt.*;

public class q6_f extends JFrame {
    JButton b1, b2, b3;
    public q6_f() {
        b1 = new JButton("b1");
        b2 = new JButton("b2");
        b3 = new JButton("b3");
        setTitle("CardLayout");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cl = new CardLayout(20,20);
        setLayout(cl );
        add(b1);
        add(b2);
        add(b3);
        setVisible(true);
        cl.show(getContentPane(), "cardlayout");
    }
    public static void main(String[] args) {
        new q6_f();
    }

}
