import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class App extends JFrame {
    JButton yes;
    JButton no;
    JLabel question;
    JPanel panel;

    App(String string) {
        super(string);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Font font = new Font("Serif", Font.ITALIC, 18);
        setBounds(600, 200, 800, 600);
        setResizable(false);
        setLayout(new BorderLayout());

        question = new JLabel("Довольны ли вы размером стипендии?");
        question.setFont(font);

        add(question, BorderLayout.NORTH);

        yes = new JButton("Да");
        yes.setFont(font);
        no = new JButton("Нет");
        no.setFont(font);
        add(yes);
        add(no);
        panel = new JPanel();
        panel.add(yes);
        panel.add(no);
        add(panel);

        yes.addActionListener(e -> JOptionPane.showMessageDialog(App.this, "Отлично! Спасибо за участие в опросе.", "Опрос", JOptionPane.INFORMATION_MESSAGE));
        no.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                moveButton();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                moveButton();
            }
        });

        no.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                moveButton();
            }
        });
    }

    private void moveButton() {
        no.setLocation(ThreadLocalRandom.current().nextInt(0, panel.getWidth()),
                ThreadLocalRandom.current().nextInt(0, panel.getHeight()));
    }

    public static void main(String[] args) {
        App app = new App("Moving button");
        app.setVisible(true);
    }
}
