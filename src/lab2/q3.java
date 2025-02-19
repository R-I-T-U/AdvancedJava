package lab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// wajp to create Menu and menu item with Acceletor and mnemonics. And handle appropriate event when menu item is clicked.
public class q3 {
    JFrame f;
    JMenuBar mb;
    JMenu m;
    JMenuItem i1, i2;
    public q3() {
        f = new JFrame("accelerator");
        mb = new JMenuBar();
        m = new JMenu("File");
        mb.add(m);
        i1 = new JMenuItem("Open");
        i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));

        i2 = new JMenuItem("New", KeyEvent.VK_N);
        i2.setMnemonic(KeyEvent.VK_N);
        i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.ALT_DOWN_MASK));

        f.setJMenuBar(mb);
        mb.add(m);
        m.add(i1);
        m.add(i2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);

        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Open File");
            }
        });
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "New File");
            }
        });
    }
    public static void main(String[] args) {
        new q3();
    }

}
