package lab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// wajp to create Menu and menu item with Acceletor and mnemonics. And handle appropriate event when menu item is clicked.
public class q3 {
    JFrame frame;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem i1, i2;
    public q3() {
        frame = new JFrame("accelerator");
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
        i1 = new JMenuItem("Open");
        i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));

        i2 = new JMenuItem("New", KeyEvent.VK_N);
        i2.setMnemonic(KeyEvent.VK_N);
        i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.ALT_DOWN_MASK));

        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(i1);
        menu.add(i2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Open File");
            }
        });
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "New File");
            }
        });
    }
    public static void main(String[] args) {
        new q3();
    }

}
