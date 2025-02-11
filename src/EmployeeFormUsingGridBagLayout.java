import javax.swing.*;
        import java.awt.*;

public class EmployeeFormUsingGridBagLayout {
    JFrame frame;
    JLabel l1, l2, l3, l4, l5, l6;
    JPasswordField p1;
    JButton b1;
    JTextArea t;
    JTextField t1, t2;
    JCheckBox c1, c2, c3;
    JRadioButton r1, r2;
    JComboBox<String> monthBox, dayBox, yearBox;

    public EmployeeFormUsingGridBagLayout() {
        frame = new JFrame("Employee Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLayout(new GridBagLayout());  // Using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Padding for better spacing
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components stretch

        // Row 1: Name
        l1 = new JLabel("Name:");
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(l1, gbc);

        t1 = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(t1, gbc);

        // Row 2: Email
        l2 = new JLabel("Email:");
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(l2, gbc);

        t2 = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(t2, gbc);

        // Row 3: Password
        l3 = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(l3, gbc);

        p1 = new JPasswordField(10);
        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(p1, gbc);

        // Row 4: DOB (Month, Day, Year)
        l4 = new JLabel("DOB:");
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(l4, gbc);

        // Month Dropdown
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthBox = new JComboBox<>(months);

        // Day Dropdown
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        dayBox = new JComboBox<>(days);

        // Year Dropdown
        String[] years = new String[36];
        for (int i = 0; i < 36; i++) {
            years[i] = String.valueOf(1990 + i);
        }
        yearBox = new JComboBox<>(years);

        // Create a panel for DOB selection (layout for neat positioning)
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dobPanel.add(monthBox);
        dobPanel.add(dayBox);
        dobPanel.add(yearBox);

        gbc.gridx = 1; gbc.gridy = 3;
        frame.add(dobPanel, gbc);

        // Row 5: Gender
        l5 = new JLabel("Gender:");
        gbc.gridx = 0; gbc.gridy = 4;
        frame.add(l5, gbc);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(r1);
        genderPanel.add(r2);

        gbc.gridx = 1; gbc.gridy = 4;
        frame.add(genderPanel, gbc);

        // Row 6: Hobbies
        l6 = new JLabel("Hobbies:");
        gbc.gridx = 0; gbc.gridy = 5;
        frame.add(l6, gbc);

        c1 = new JCheckBox("Coding");
        c2 = new JCheckBox("Designing");
        c3 = new JCheckBox("Gaming");

        JPanel hobbiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hobbiesPanel.add(c1);
        hobbiesPanel.add(c2);
        hobbiesPanel.add(c3);

        gbc.gridx = 1; gbc.gridy = 5;
        frame.add(hobbiesPanel, gbc);

        // Row 7: Submit Button
        b1 = new JButton("Submit");
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(b1, gbc);

        // Row 8: Output Text Area
        t = new JTextArea(5, 30);
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(t);

        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        frame.add(scrollPane, gbc);

        // Show frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeFormUsingGridBagLayout();
    }
}
