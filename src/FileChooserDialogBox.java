import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class FileChooserDialogBox {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("File Chooser Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a button to open the file chooser
        JButton button = new JButton("Choose File");
        button.setBounds(140, 50, 120, 30);

        // Label to display the selected file path
        JLabel label = new JLabel("Selected File: None");
        label.setBounds(20, 100, 360, 30);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    label.setText("Selected File: " + selectedFile.getAbsolutePath());
                }
            }
        });

        // Add components to frame
        frame.add(button);
        frame.add(label);

        // Set frame visibility
        frame.setVisible(true);
    }
}