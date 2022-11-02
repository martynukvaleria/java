import java.awt.*;
import javax.swing.*;

public class DrawingFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SimpleJFrameExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
} 