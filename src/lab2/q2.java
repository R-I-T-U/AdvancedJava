package lab2;

import javax.swing.*;
import java.awt.*;
// wajp to implement slider and JScrollpane component in swing.

public class q2 {
    public q2() {
        JFrame f = new JFrame("Slider & ScrollPane");
        f.setLayout(new BorderLayout(10, 10));

        JPanel p1 = new JPanel(new FlowLayout());
        JLabel l1 = new JLabel("Age: ");
        JSlider s = new JSlider(0, 60, 10);
        s.setMajorTickSpacing(10);
        s.setMinorTickSpacing(5);
        s.setPaintTicks(true);
        s.setPaintLabels(true);
        p1.add(l1);
        p1.add(s);

        JPanel p2 = new JPanel(new BorderLayout());
        JLabel l2 = new JLabel("Comment: ");
        JTextArea ta = new JTextArea(5, 20);
        JScrollPane sp = new JScrollPane(ta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p2.add(l2, BorderLayout.NORTH);
        p2.add(sp, BorderLayout.CENTER);

        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.CENTER);

        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new q2();
    }
}
