import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// write a gui application to calculate simple interest. use three text fields
// for input and fourth text fields for output. Your program should display simple interest if user press the button.
public class q2 {
    JFrame frame;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1;
    public q2() {
        frame = new JFrame("Simple Interest");
        l1 = new JLabel("Enter Principal");
        l2 = new JLabel("Enter Rate");
        l3 = new JLabel("Enter Time");
        l4 = new JLabel("Simple Interest");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        b1 = new JButton("Calculate");

        frame.setSize(500, 500);
        frame.setLayout(null);
        l1.setBounds(10, 10, 150, 25);
        t1.setBounds(200, 10, 100, 25);

        l2.setBounds(10, 50, 150, 25);
        t2.setBounds(200, 50, 100, 25);

        l3.setBounds(10, 100, 150, 25);
        t3.setBounds(200, 100, 100, 25);

        b1.setBounds(100, 150, 150, 25);

        l4.setBounds(10, 200, 150, 25);
        t4.setBounds(200, 200, 100, 25);



        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);

        frame.add(l1);
        frame.add(t1);

        frame.add(l2);
        frame.add(t2);

        frame.add(b1);
        frame.add(l3);
        frame.add(t3);
        frame.add(l4);
        frame.add(t4);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = Integer.parseInt(t3.getText());
                double d = (a*b*c)/100;
                t4.setText(Double.toString(d));
            }
        });


    }

    public static void main(String[] args) {
        new q2();
    }
}
