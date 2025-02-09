import javax.swing.*;
import java.awt.*;

// Design a GUI form using swing with text-field, a text label for displaying the input message "Input any string"
// and three button with caption checkPalindrome, Reverse, FindVowels. Write a complete program for above scenario and for checking palindrome in first button ,
// reverse it after clicking second button and extract vowel from it clicking third button
public class q5 {
    JFrame f;
    JTextField t1;
    JLabel l1, l2;
    JButton b1, b2, b3;

    public q5() {
        f = new JFrame();
        t1 = new JTextField(25);
        l1 = new JLabel("Input any string ");
        l2 = new JLabel();
        b1 = new JButton("Check Palindrome");
        b2 = new JButton("Reverse");
        b3 = new JButton("Find Vowels");
        f.setSize(400, 400);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
        f.setLayout(null);

        l1.setBounds(10, 10, 200, 20);
        t1.setBounds(150, 10, 200, 20);

        b1.setBounds(100, 40, 200, 20);
        b2.setBounds(100, 80, 200, 20);
        b3.setBounds(100, 120, 200, 20);

        l2.setBounds(10, 160, 200, 20);

        f.add(t1);
        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(l2);


    }
    public static void main(String[] args) {
        new q5();
    }
}
