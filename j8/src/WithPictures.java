import javax.swing.*;

public class WithPictures extends JPanel {

    public WithPictures() {
        super();
        setBounds(600, 200, 550, 440);
        pictures();
    }

    public void pictures() {
        Box box = new Box(1);
        ButtonGroup buttonGroup = new ButtonGroup();
        ImageIcon[] ICONS = {
                new ImageIcon("src/portrait.jpg"),
                new ImageIcon("src/stillife.jpg"),
                new ImageIcon("src/landscape.jpg"),
                new ImageIcon("src/marine.jpg"),
                new ImageIcon("src/next.jpg"),
                new ImageIcon("src/sea.jpg")
        };

        for (int i = 0; i < 4; i++) {
            JRadioButton radioButton = new JRadioButton(ICONS[0]);
            radioButton.setPressedIcon(ICONS[1]);
            radioButton.setRolloverIcon(ICONS[2]);
            radioButton.setSelectedIcon(ICONS[3]);
            radioButton.setRolloverSelectedIcon(ICONS[4]);
            buttonGroup.add(radioButton);
            box.add(radioButton);
        }
        add(box);
    }
}
