package lab2;
// wajp to implement slider and JScrollpane component in swing.

import javax.swing.*;
import java.awt.*;

public class q2 {
    JFrame frame;
    JTextArea textArea;
    JScrollPane scrollPane;
    JSlider slider;
    JLabel l1, l2;
    public q2() {
        frame = new JFrame();
        l1 = new JLabel("comment: ");
        l2 = new JLabel("Age: ");
        textArea = new JTextArea(10, 10);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        slider = new JSlider(0, 60, 10);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2, 10,10));
        frame.setVisible(true);

        frame.add(l2);frame.add(slider);
        frame.add(l1);frame.add(scrollPane);

    }
    public static void main(String[] args) {
        new q2();
    }
}
