package lab2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// wajp to illustrate the following swing component
// a. Popup menu
public class q4_a {
    JFrame frame;
    JPopupMenu p;
    JMenuItem i1,i2, i3;
    public q4_a() {
        frame = new JFrame();
        p = new JPopupMenu("Edit");
        i1 = new JMenuItem("copy");
        i2 = new JMenuItem("paste");
        i3 = new JMenuItem("cut");

        p.add(i1);
        p.add(i2);
        p.add(i3);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                p.show(frame, e.getX(), e.getY());
            }
        });

    }
    public static void main(String[] args) {
        new q4_a();
    }
}
