import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class Window extends JFrame implements Observable {
    private final List<Observer> observers;

    public Window() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,200,700,700);
        setLayout(new BorderLayout());

        observers = new ArrayList<>();

        JLabel label = new JLabel();
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 150));

        JList<String> list = new JList<>(new DefaultListModel<>());
        list.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));

        First first = new First(label);
        Second second = new Second((DefaultListModel<String>) list.getModel());
        attach(first);
        attach(second);

        add(label, BorderLayout.WEST);
        add(list, BorderLayout.EAST);

        list.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Window.this.myNotify(e);
            }
        });
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void myNotify(EventObject object) {
        for (Observer observer : observers) {
            observer.update(object);
        }
    }

    public static void main(String[] args) {
        Window frame = new Window();
        frame.setVisible(true);
    }
}
