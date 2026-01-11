import javax.swing.*;
import java.awt.*;


public class ShapeDrawer extends JFrame {
    String shape = "Rectangle";
    Color color = Color.RED;

    public ShapeDrawer(int width, int height, int x, int y) {
     
        setTitle("Shape Drawer");
        setSize(width, height);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JMenuBar menuBar = new JMenuBar();

       
        JMenu shapeMenu = new JMenu("Shapes");
        String[] shapes = {"Rectangle", "Oval", "Line"};
        for (String s : shapes) {
            JMenuItem item = new JMenuItem(s);
            item.addActionListener(e -> {
                shape = s;
                repaint();  // redraw
            });
            shapeMenu.add(item);
        }

     
        JMenu colorMenu = new JMenu("Colors");
        JMenuItem red = new JMenuItem("Red");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem blue = new JMenuItem("Blue");

        red.addActionListener(e -> { color = Color.RED; repaint(); });
        green.addActionListener(e -> { color = Color.GREEN; repaint(); });
        blue.addActionListener(e -> { color = Color.BLUE; repaint(); });

        colorMenu.add(red);
        colorMenu.add(green);
        colorMenu.add(blue);

        menuBar.add(shapeMenu);
        menuBar.add(colorMenu);
        setJMenuBar(menuBar);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        int w = 100, h = 60;

        switch (shape) {
            case "Rectangle":
                g.fillRect(150, 150, w, h);
                break;
            case "Oval":
                g.fillOval(150, 150, w, h);
                break;
            case "Line":
                g.drawLine(150, 150, 150 + w, 150 + h);
                break;
        }
    }

    public static void main(String[] args) {
      
        if (args.length != 4) {
            System.out.println("Usage: java ShapeDrawer <width> <height> <x> <y>");
            System.exit(1);
        }

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int x = Integer.parseInt(args[2]);
        int y = Integer.parseInt(args[3]);

       
        ShapeDrawer frame = new ShapeDrawer(width, height, x, y);
        frame.setVisible(true);
    }
}