package lab3;

import javax.swing.*;
import java.awt.*;

public class q3 extends Canvas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Shapes");
        Canvas canvas = new q3();
        canvas.setSize(500, 500);
        frame.add(canvas);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        g.drawLine(20, 10, 100, 20);
        g.drawRect(20, 40, 50, 50);
        g.fillRect(80, 40, 50, 50);

        g.drawOval(20, 100, 50, 50);
        g.fillOval(100, 100, 50, 50);

        g.drawOval(20, 200,80,40 );
        g.fillOval(150, 200,80,40 );

        int[] x = {100, 150, 200, 200, 150, 100};
        int[] y = {300, 270, 300, 350, 380, 350};
        g.drawPolygon(x, y, 6);

        int[] x2 = {250, 300, 350, 350, 300, 250};
        int[] y2 = {300, 270, 300, 350, 380, 350};
        g.fillPolygon(x2, y2, 6);

    }
}
