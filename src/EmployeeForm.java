import javax.swing.*;
import java.awt.*;

public class EmployeeForm {
    JFrame frame;
    JLabel l1, l2, l3, l4, l5, l6;
    JPasswordField p1;
    JButton b1;
    JTextArea t;
    JTextField t1, t2;
    JCheckBox c1, c2, c3;
    JRadioButton r1, r2;
    JComboBox<String> monthBox, dayBox, yearBox;

    public EmployeeForm() {
        frame = new JFrame("Employee Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLayout(null);

        // Labels and Text Fields
        l1 = new JLabel("Name:");
        l1.setBounds(20, 20, 100, 25);
        t1 = new JTextField(10);
        t1.setBounds(150, 20, 200, 25);

        l2 = new JLabel("Email:");
        l2.setBounds(20, 60, 100, 25);
        t2 = new JTextField(10);
        t2.setBounds(150, 60, 200, 25);

        l3 = new JLabel("Password:");
        l3.setBounds(20, 100, 100, 25);
        p1 = new JPasswordField(10);
        p1.setBounds(150, 100, 200, 25);

        // DOB Section
        l4 = new JLabel("DOB:");
        l4.setBounds(20, 140, 100, 25);

        // Month Dropdown
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(150, 140, 70, 25);

        // Day Dropdown (1-31)
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        dayBox = new JComboBox<>(days);
        dayBox.setBounds(230, 140, 50, 25);

        // Year Dropdown (1990-2025)
        String[] years = new String[36];
        for (int i = 0; i < 36; i++) {
            years[i] = String.valueOf(1990 + i);
        }
        yearBox = new JComboBox<>(years);
        yearBox.setBounds(290, 140, 80, 25);

        // Gender Section
        l5 = new JLabel("Gender:");
        l5.setBounds(20, 180, 100, 25);
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        r1.setBounds(150, 180, 80, 25);
        r2.setBounds(230, 180, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        // Hobbies Section
        l6 = new JLabel("Hobbies:");
        l6.setBounds(20, 220, 100, 25);
        c1 = new JCheckBox("Coding");
        c2 = new JCheckBox("Designing");
        c3 = new JCheckBox("Gaming");
        c1.setBounds(150, 220, 80, 25);
        c2.setBounds(230, 220, 100, 25);
        c3.setBounds(310, 220, 100, 25);

        // Submit Button
        b1 = new JButton("Submit");
        b1.setBounds(150, 260, 100, 30);

        // Output Text Area
        t = new JTextArea();
        t.setBounds(20, 310, 380, 100);

        // Adding components to frame
        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(l3);
        frame.add(p1);
        frame.add(l4);
        frame.add(monthBox);
        frame.add(dayBox);
        frame.add(yearBox);
        frame.add(l5);
        frame.add(r1);
        frame.add(r2);
        frame.add(l6);
        frame.add(c1);
        frame.add(c2);
        frame.add(c3);
        frame.add(b1);
        frame.add(t);

        // Show frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeForm();
    }
}
