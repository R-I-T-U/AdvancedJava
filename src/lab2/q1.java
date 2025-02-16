package lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// wajp using swing component to create student registration form with field (text field for name,
// address, email , password, radio button for Gender, checkbox for Hobbies, country as dropdown list,
// opinion as text area, one button for submit) your program display the student information when user click on submit button.
public class q1 {
    JFrame frame;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1, t2, t3, t4;
    JRadioButton r1, r2;
    JCheckBox c1, c2, c3;
    JTextArea ta;
    JButton b1;
    JComboBox cb;
    public q1() {
        frame = new JFrame("Student Form");
        l1 = new JLabel("Name");
        l2 = new JLabel("Address");
        l3 = new JLabel("Email");
        l4 = new JLabel("Password");
        l5 = new JLabel("Gender");
        l6 = new JLabel("Hobbies");
        l7 = new JLabel("Country");
        l8 = new JLabel("Opinion");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        c1 = new JCheckBox("Coding");
        c2 = new JCheckBox("Designing");
        c3 = new JCheckBox("Gaming");

        ta = new JTextArea(20, 20);

        String country[] = {"Nepal", "Australia", "Japan", "china"};
        cb = new JComboBox(country);

        b1 = new JButton("Submit");

        frame.add(l1);frame.add(t1);
        frame.add(l2);frame.add(t2);
        frame.add(l3);frame.add(t3);
        frame.add(l4); frame.add(t4);
        frame.add(l5);frame.add(r1); frame.add(r2);
        frame.add(l6); frame.add(c1); frame.add(c2); frame.add(c3);
        frame.add(l7); frame.add(cb);
        frame.add(l8);frame.add(ta);
        frame.add(b1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = t1.getText();
                String address = t2.getText();
                String email = t3.getText();
                String password = t4.getText();

                String gender ="";
                if(r1.isSelected())
                    gender = "Male";
                else if(r2.isSelected())
                    gender = "Female";


                String hobbies = "";
                if(c1.isSelected())
                    hobbies += "Coding ";
                if(c2.isSelected())
                    hobbies += "Designing ";
                if(c3.isSelected())
                    hobbies += "Gaming ";

                String country = cb.getSelectedItem().toString();
                String opinion = t4.getText();
                JOptionPane.showMessageDialog(frame, "Name: "+name+" \n Address:"+address+" \n Email:"+email+" \n gender:"+gender+" \n password:"+password+" \n hobbies:"+hobbies+" \n Country:"+country+" \n Opinion:"+opinion);
            }
        });
    }
    public static void main(String[] args) {
        new q1();
    }

}
