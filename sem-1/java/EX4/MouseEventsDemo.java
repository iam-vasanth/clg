package EX4;
import java.awt.*;
import java.awt.event.*;

public class MouseEventsDemo extends Frame implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 0, mouseY = 0;

    public MouseEventsDemo() {
        addMouseListener(this);
        addMouseMotionListener(this);

        setTitle("Mouse Events Example");
        setSize(400, 300);
        setVisible(true);

            addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    
    public void mouseClicked(MouseEvent me) {
        msg = "Mouse Clicked";
        repaint();
    }

    public void mouseEntered(MouseEvent me) {
        msg = "Mouse Entered";
        repaint();
    }

    public void mouseExited(MouseEvent me) {
        msg = "Mouse Exited";
        repaint();
    }

    public void mousePressed(MouseEvent me) {
        msg = "Mouse Pressed";
        repaint();
    }

    public void mouseReleased(MouseEvent me) {
        msg = "Mouse Released";
        repaint();
    }

    
    public void mouseDragged(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Dragging at " + mouseX + ", " + mouseY;
        repaint();
    }

    public void mouseMoved(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Moving at " + mouseX + ", " + mouseY;
        repaint();
    }

   
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String[] args) {
        new MouseEventsDemo();
    }
}