package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class q2_b {
    JFrame frame;
    JButton button;
    JLabel label;
    public q2_b() {
        frame = new JFrame("File chooser");
        button = new JButton("Choose File");
        label = new JLabel("Selected File: ");
        frame.add(button);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setLayout(new FlowLayout());
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int ret = chooser.showOpenDialog(frame);
                if(ret == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    label.setText("File selected: " + file.getAbsolutePath());
                }
            }
        });

    }
    public static void main(String[] args) {
        new q2_b();
    }
}
