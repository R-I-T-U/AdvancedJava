package lab1;

import javax.swing.*;
import java.awt.*;

public class q6_d {
    JFrame frame;
    JButton b1, b2, b3;
    public q6_d() {
        frame = new JFrame("GridBagLayout");
        b1 = new JButton("b1");
        b2 = new JButton("b2");
        b3 = new JButton("b3");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(b1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(b2, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(b3, gbc);
    }
    public static void main(String[] args) {
        new q6_d();
    }
}
