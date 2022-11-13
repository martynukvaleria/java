import javax.swing.*;

public class TabbedPane extends JFrame {
    public TabbedPane() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300,500, 800, 700);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("first task", new List());
        tabbedPane.addTab("second task", new Grid());
        tabbedPane.addTab("third task", new WithPictures());
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        TabbedPane frame = new TabbedPane();
    }
}