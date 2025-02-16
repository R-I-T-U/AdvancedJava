package lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = t1.getText();
                boolean checkPalindrome = true; // Assume it's a palindrome initially

                for (int i = 0; i < a.length() / 2; i++) {
                    if (a.charAt(i) != a.charAt(a.length() - 1 - i)) {
                        checkPalindrome = false;
                        break; // Stop checking if a mismatch is found
                    }
                }

                if (checkPalindrome) {
                    l2.setText("Palindrome");
                } else {
                    l2.setText("Not Palindrome");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = t1.getText();
                String reverse = "";
                for(int i = 0; i < a.length(); i++) {
                        reverse += a.charAt(a.length()-1-i);
                }
                l2.setText("Reversed: "+reverse);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = t1.getText();
                String vowels = "aeiouAEIOU";
                String vowel ="";
                for(int i = 0; i < a.length(); i++) {
                    for(int j = 0; j < vowels.length(); j++) {
                        if(a.charAt(i) == vowels.charAt(j)){
                            vowel += a.charAt(i);
                        }
                    }
                }
                l2.setText("Vowels: "+vowel);
            }
        });

    }
    public static void main(String[] args) {
        new q5();
    }
}
