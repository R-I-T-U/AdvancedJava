package lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//wap using swing component to add and subtract two numbers. use text fields for inputs and output. Your program should display the result when user press button
public class q1 {
    JFrame frame;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;
    public q1() {
        frame = new JFrame("add and subtract");
        l1 = new JLabel("Enter First Number");
        l2 = new JLabel("Enter Second Number");
        l3 = new JLabel("Output");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        b1 = new JButton("Add");
        b2 = new JButton("Subtract");
        frame.setSize(500, 500);
        frame.setLayout(null);
        l1.setBounds(10, 10, 100, 25);
        t1.setBounds(150, 10, 100, 25);

        l2.setBounds(10, 50, 100, 25);
        t2.setBounds(150, 50, 100, 25);

        b1.setBounds(100, 100, 100, 25);
        b2.setBounds(200, 100, 100, 25);

        l3.setBounds(10, 150, 100, 25);
        t3.setBounds(150, 150, 100, 25);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);

        frame.add(l1);
        frame.add(t1);

        frame.add(l2);
        frame.add(t2);

        frame.add(b1);
        frame.add(b2);
        frame.add(l3);
        frame.add(t3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = a+b;
                l3.setText("Sum  ");
                t3.setText(Integer.toString(c));
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = a-b;
                l3.setText("Subtract  ");
                t3.setText(Integer.toString(c));
            }
        });

    }

    public static void main(String[] args) {
        new q1();
    }
}
