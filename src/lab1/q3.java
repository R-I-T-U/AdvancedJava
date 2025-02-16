package lab1;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// wajp using swing component to find area and perimeter of rectangle. use text field for inputs and outputs. The program should display area if user presses
// mouse and perimeter if user release mouse.
public class q3 {
    JFrame frame;
    JLabel l1, l2 , l3;
    JTextField t1, t2, t3;
   public q3() {
       frame = new JFrame("rectangle");
       l1 = new JLabel("Length");
       l2 = new JLabel("Breadth");
       l3 = new JLabel("Output");
       t1 = new JTextField(10);
       t2 = new JTextField(10);
       t3 = new JTextField(10);

       frame.setSize(400, 400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(null);
       frame.setVisible(true);

       l1.setBounds(10, 10, 150, 25);
       t1.setBounds(200, 10, 100, 25);

       l2.setBounds(10, 50, 150, 25);
       t2.setBounds(200, 50, 100, 25);

       l3.setBounds(10, 100, 150, 25);
       t3.setBounds(200, 100, 100, 25);

       frame.add(l1);
       frame.add(t1);
       frame.add(l2);
       frame.add(t2);
       frame.add(l3);
       frame.add(t3);

       frame.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               int l = Integer.parseInt(t1.getText());
               int b = Integer.parseInt(t2.getText());
               double area = l*b;
               l3.setText("Area  ");
               t3.setText(Double.toString(area));
           }

           public void mouseReleased(MouseEvent e) {
               int l = Integer.parseInt(t1.getText());
               int b = Integer.parseInt(t2.getText());
               double peri = 2*(l+b);
               l3.setText("Perimeter  ");
               t3.setText(Double.toString(peri));
           }
       });

   }
   public static void main(String[] args) {
       new q3();
   }
}
