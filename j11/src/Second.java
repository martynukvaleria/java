import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.EventObject;

public class Second implements Observer{
    private final DefaultListModel<String> model;

   Second(DefaultListModel<String> model){
        this.model = model;
    }
    @Override
    public void update(EventObject e) {
        model.add(0, KeyEvent.getKeyText(((KeyEvent) e).getKeyCode()));
    }
}
