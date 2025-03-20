package lab3;

import javax.swing.*;

public class q2_c {
    JFrame f;
    JDesktopPane desktop;
    JInternalFrame f1, f2;
    public q2_c() {
        f = new JFrame("JDesktopPane and Internal Frames");
        f1 = new JInternalFrame("Frame1", true, true, true, true);
        f2 = new JInternalFrame("Frame2", true, true, true, true);

        desktop = new JDesktopPane();
        f.add(desktop);
        f.setVisible(true);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(3);

        f1.setSize(200, 200);
        f2.setSize(200, 200);
        f1.add(new JLabel("Frame 1"));
        f2.add(new JLabel("Frame 2"));
        f1.setVisible(true);
        f2.setVisible(true);
        desktop.add(f1);
        desktop.add(f2);

    }
    public static void main(String[] args) {
        new q2_c();
    }
}
