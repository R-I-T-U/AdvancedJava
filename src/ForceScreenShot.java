// Hamlai class ma sikako xna hai yo

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ForceScreenShot {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

            // Save the screenshot
            ImageIO.write(screenFullImage, "png", new File("screenshot.png"));
            System.out.println("Screenshot saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
