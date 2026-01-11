import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageViewerBean extends JPanel {
    private BufferedImage image;

    public void setImage(String path) {
        try {
            image = ImageIO.read(new File(path));
            repaint();
        } catch (IOException e) {
            System.out.println("Image could not be loaded: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int x = (getWidth() - image.getWidth()) / 2;
            int y = (getHeight() - image.getHeight()) / 2;
            g.drawImage(image, x, y, this);
        }
    }
}