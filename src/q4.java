import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//wajp to find the smallest and largest among three members using swing components. Use text fields for input and output. Your program displays
//output if you press any key in keyboard. Use key adapter to handle events.
public class q4 {
    JFrame f;
    JLabel l1,l2,l3,l4, l5;
    JTextField t1, t2, t3, t4, t5, t6;
    public q4() {
        f = new JFrame();
        l1 = new JLabel("Number 1");
        l2 = new JLabel("Number 2");
        l3 = new JLabel("Number 3");
        l4 = new JLabel("Smallest");
        l5= new JLabel("Largest");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);

        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
        l1.setBounds(10, 10, 100, 25);
        t1.setBounds(150, 10, 100, 25);

        l2.setBounds(10, 50, 100, 25);
        t2.setBounds(150, 50, 100, 25);

        l3.setBounds(10, 100, 100, 25);
        t3.setBounds(150, 100, 100, 25);

        t6.setBounds(10, 150, 250, 25);

        l4.setBounds(10, 200, 100, 25);
        t4.setBounds(150, 200, 100, 25);

        l5.setBounds(10, 250, 100, 25);
        t5.setBounds(150, 250, 100, 25);

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(t3);
        f.add(l4);
        f.add(t4);
        f.add(t5);
        f.add(l5);
        f.add(t6);

        t6.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = Integer.parseInt(t3.getText());
                int max = (a>b)?((a>c)?a:c):b;
                int min = (a<b)?((a<c)?a:c):b;

                t4.setText(Integer.toString(min));
                t5.setText(Integer.toString(max));
            }
        });

    }
    public static void main(String[] args) {
        new q4();
    }
}
