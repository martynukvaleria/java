import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    JButton button;
    JLabel mousePosition;

    Window(String string) {
        super(string);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(600, 200, 800, 600);
        setResizable(false);
        setLayout(new BorderLayout());

        button = new JButton("click me");
        button.setBounds(getX() / 2 + 50, getY() - 100, 90, 50);

        mousePosition = new JLabel(" ");
        add(mousePosition, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel, BorderLayout.CENTER);
        panel.add(button);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mousePosition(e.getX(), e.getY());
                button.setLocation(e.getX(), e.getY());
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mousePosition(e.getX(), e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                mouseMoved(e);
            }
        });

        button.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mousePosition(e.getX() + button.getX(), e.getY() + button.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.isControlDown()) {
                    button.setLocation(e.getX() + button.getX(), e.getY() + button.getY());
                    mousePosition(e.getX() + button.getX(), e.getY() + button.getY());
                }
            }
        });
        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    StringBuilder string = new StringBuilder(button.getText());
                    try {
                        string.deleteCharAt(string.length() - 1);
                    } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                        return;
                    }
                    button.setText(String.valueOf(string));
                    button.setSize(button.getPreferredSize());
                    return;
                }
                button.setText(button.getText() + e.getKeyChar());
                button.setSize(button.getPreferredSize());
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    void mousePosition(int x, int y) {
        mousePosition.setText("x : " + x + " y :" + y);
    }

    public static void main(String[] args) {
        Window window = new Window("Moving button");
        window.setVisible(true);
    }
}

