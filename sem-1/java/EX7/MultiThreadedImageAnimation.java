package EX7;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MultiThreadedImageAnimation extends JFrame {

    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();

    String[] imagePaths = {
        "cat1.jpeg", 
        "cat2.jpeg", 
        "cat3.jpeg"
    };

    public MultiThreadedImageAnimation() {
        setTitle("Multi-threaded Image Animation");
        setLayout(new GridLayout(3, 1));
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(label1);
        add(label2);
        add(label3);

        new Thread(new ImageAnimator(label1, 500)).start();
        new Thread(new ImageAnimator(label2, 1000)).start();
        new Thread(new ImageAnimator(label3, 1500)).start();

        setVisible(true);
    }

    class ImageAnimator implements Runnable {
        JLabel label;
        int interval;
        Random rand = new Random();

        public ImageAnimator(JLabel label, int interval) {
            this.label = label;
            this.interval = interval;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int index = rand.nextInt(imagePaths.length);
                    ImageIcon icon = new ImageIcon(imagePaths[index]);
                    label.setIcon(icon);
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    System.out.println("Animation interrupted.");
                }
            }
        }
    }

    //main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MultiThreadedImageAnimation();
            }
        });
    }
}