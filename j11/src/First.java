import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.EventObject;

public class First implements Observer{
    private final JLabel label;

    First(JLabel label){
        this.label = label;
    }

    @Override
    public void update(EventObject e) {
        label.setText(KeyEvent.getKeyText(((KeyEvent) e).getKeyCode()));
    }
}
