import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Grid extends JPanel {

    public static final int BUTTONS_ROUND_AMOUNT = 3;
    private final String WORD = "Clicked!";
    String text;

    public Grid() {
        super();
        setLayout(new GridLayout(BUTTONS_ROUND_AMOUNT, BUTTONS_ROUND_AMOUNT));
        setBounds(400, 200, 600, 600);

        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JButton button = (JButton) e.getSource();
                    text = button.getText();
                    button.setBackground(Color.BLUE);
                    button.setText(WORD);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JButton button = (JButton) e.getSource();
                    button.setText(text);

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(null);
            }
        };
        for (int i = 1; i <= BUTTONS_ROUND_AMOUNT * BUTTONS_ROUND_AMOUNT; i++) {
            JButton button = new JButton(i + " ");
            add(button);
            button.addMouseListener(listener);
        }
    }
}
