package EX11;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeViewerExample extends JFrame {

    public TreeViewerExample() {
        // Create root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Courses");

        // Create child nodes
        DefaultMutableTreeNode ug = new DefaultMutableTreeNode("UG");
        DefaultMutableTreeNode pg = new DefaultMutableTreeNode("PG");

        // Add children to UG
        ug.add(new DefaultMutableTreeNode("B.Sc CS"));
        ug.add(new DefaultMutableTreeNode("BCA"));
        ug.add(new DefaultMutableTreeNode("B.Sc IT"));

        // Add children to PG
        pg.add(new DefaultMutableTreeNode("M.Sc CS"));
        pg.add(new DefaultMutableTreeNode("MCA"));

        // Add UG and PG to root
        root.add(ug);
        root.add(pg);

        // Create tree
        JTree tree = new JTree(root);

        // Add tree to scroll pane
        JScrollPane treeView = new JScrollPane(tree);

        // Set frame properties
        add(treeView);
        setTitle("Tree Viewer - Course Hierarchy");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new TreeViewerExample());
    }
}