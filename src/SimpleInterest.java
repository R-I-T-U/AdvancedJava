import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleInterest implements ActionListener {
    JFrame frame;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3;
    JButton btn;

    public SimpleInterest() {
        frame = new JFrame("Simple Interest");

        l1 = new JLabel("Principal:");
        l2 = new JLabel("Rate:");
        l3 = new JLabel("Time:");
        l4 = new JLabel();

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        btn = new JButton("Calculate");

        frame.setLayout(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns

        frame.add(l1); frame.add(t1);
        frame.add(l2); frame.add(t2);
        frame.add(l3); frame.add(t3);
        frame.add(btn);
        frame.add(l4);

        btn.addActionListener(this);

        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
            double principal = Double.parseDouble(t1.getText());
            double rate = Double.parseDouble(t2.getText());
            double time = Double.parseDouble(t3.getText());

            double interest = (principal * rate * time) / 100;

            l4.setText("Interest: " + interest);

    }

    public static void main(String[] args) {
        new SimpleInterest();
    }
}
