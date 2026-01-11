import javax.swing.*;

public class ImageViewerTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Viewer Bean Example");
        ImageViewerBean imageBean = new ImageViewerBean();

        // Set the image path here
        imageBean.setImage("/home/zoro/Documents/College/Java/EX12/employee.png");

        frame.add(imageBean);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}