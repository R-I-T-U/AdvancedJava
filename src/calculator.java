import javax.swing.*;
import java.awt.*;

public class calculator {

    JFrame frame;
    JPanel topPanel;
    JTextField display;
    JPanel bottomPanel;
    JButton btn;

    public calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        topPanel = new JPanel();
        display = new JTextField(25);

        topPanel.add(display);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4, 4, 5, 5)); // Grid layout for buttons
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+"
        };
        for (String text : buttons) {
            btn = new JButton(text);
            bottomPanel.add(btn);
        }
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new calculator();
    }
}
