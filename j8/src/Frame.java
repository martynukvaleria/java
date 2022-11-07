import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame {

    public static final int BUTTONS_ROUND_AMOUNT = 3;
    final String WORD = "Clicked";
    String text;

    public Frame(){

        super("Buttons");
        setLayout(new GridLayout(BUTTONS_ROUND_AMOUNT, BUTTONS_ROUND_AMOUNT));
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1){
                    JButton button = (JButton) e.getSource();
                    text = button.getText();
                    button.setText(WORD);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1){
                    JButton button = (JButton) e.getSource();
                    button.setText(text);

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        for (int i = 0; i <= BUTTONS_ROUND_AMOUNT * BUTTONS_ROUND_AMOUNT; i++){
            JButton button = new JButton(i + " ");
            add(button);
            button.addMouseListener(listener);
        }
    }
    public static void main(String[] args){
        Frame frame = new Frame();
        frame.setVisible(true);
    }
}
