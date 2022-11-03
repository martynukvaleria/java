
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;

public class DrawingFrame extends JFrame {
    private static Color color = Color.black;
    private final JButton buttonColor = new JButton("Color");
    private final JButton buttonOpen = new JButton("Open");
    private final JButton buttonSave = new JButton("Save");
    private final List<MyLine> lines = new ArrayList<>();
    private MyLine currentLine;
    private final DrawingCanvas drawingPanel;

    public static void main(String[] args) {
        new DrawingFrame("Paint");
    }

    public DrawingFrame(String string) {
        super(string);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingPanel = new DrawingCanvas();
        drawingPanel.setPreferredSize(new Dimension(800, 600));
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentLine = new MyLine(color);
                lines.add(currentLine);
                currentLine.addPoint(e.getX(), e.getY());
            }
        });
        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentLine.addPoint(e.getX(), e.getY());
                repaint();
            }
        });
        buttonColor.addActionListener(e -> {
            Color tempColor = JColorChooser.showDialog(buttonColor, "Choose a color", color);
            if (tempColor != null) {
                color = tempColor;
            }
        });
        buttonOpen.addActionListener((e -> {
            try (Scanner scanner = new Scanner(Objects.requireNonNull(GetFile("Text files", "txt", true)))) {
                lines.clear();
                while (scanner.hasNext()) {
                    MyLine tempLine = new MyLine(Color.black);
                    lines.add(tempLine);
                    int size = scanner.nextInt();
                    for (int i = 0; i < size; i++)
                        tempLine.addPoint(scanner.nextInt(), scanner.nextInt());
                    tempLine.setColor(new Color(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
                }
                repaint();
            } catch (IOException | NullPointerException exception) {
                JOptionPane.showMessageDialog(buttonOpen, exception, "Error!", JOptionPane.PLAIN_MESSAGE);
            }
        }));
        buttonSave.addActionListener(e -> {
            BufferedImage im = new BufferedImage(drawingPanel.getWidth(), drawingPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
            drawingPanel.paint(im.getGraphics());
            try {
                ImageIO.write(im, "png", Objects.requireNonNull(GetFile("Images (.png)", "png", false)));
            } catch (IOException | NullPointerException exception) {
                JOptionPane.showMessageDialog(buttonSave, exception, "Error!", JOptionPane.PLAIN_MESSAGE);
            }
        });

        Box vertical = new Box(1);
        Box horizontal = new Box(2);
        vertical.add(drawingPanel);
        horizontal.add(buttonColor);
        horizontal.add(buttonOpen);
        horizontal.add(buttonSave);
        vertical.add(new JScrollPane(drawingPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        vertical.add(horizontal);
        add(vertical);

        pack();
        setVisible(true);

    }

    public class DrawingCanvas extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (MyLine line : lines) {
                line.draw(g);
            }
            setBackground(Color.white);
        }
    }

    private File GetFile(String filterName, String fileExt, Boolean open) {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);
        if (open) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter(filterName, fileExt);
            chooser.setFileFilter(filter);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
                return chooser.getSelectedFile();
            else
                return null;
        } else {
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
                return chooser.getSelectedFile();
            else
                return null;
        }
    }
}