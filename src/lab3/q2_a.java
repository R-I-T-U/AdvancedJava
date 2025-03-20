package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class q2_a {
    JFrame frame;
    JButton button;
    public q2_a(){
        frame = new JFrame("Color chooser");
        button = new JButton("Choose color");
        frame.add(button);
        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Color in = Color.RED;
                Color c = JColorChooser.showDialog(frame, "Choose a color", in);
                frame.getContentPane().setBackground(c);
            }
        });
    }
    public static void main(String[] args) {
        new q2_a();
    }
}
