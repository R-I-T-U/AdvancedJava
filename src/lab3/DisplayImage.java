package lab3;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;

public class DisplayImage extends Canvas {
    public static void main(String[] args) {
        JFrame f = new JFrame("ID Card");
        Canvas cv = new DisplayImage();
        cv.setSize(300, 450);
        f.add(cv);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
    }

    public void paint(Graphics g) {
        try {
            BufferedImage img = ImageIO.read(getClass().getResource("img.png"));
            g.drawImage(img, 30, 30, 250, 250, this);
            Font f = new Font("monospace", Font.BOLD, 15);
            g.setFont(f);
            g.drawString("Name: Ritu Khwalapala",30, 300);
            g.drawString("Section: B",30, 320);
            g.drawString("Roll no.: 36",30, 340);
            g.drawString("Address.:Bkt",30, 360);


        } catch (Exception e) {

        }
    }
}