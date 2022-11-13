import javax.swing.*;
import java.awt.*;

public class List extends JPanel {
    private final JList<String> firstList;
    private final JList<String> secondList;
    JButton toSecond;
    JButton toFirst;
    JPanel panel;

    public List() {
        super();
        setBounds(200, 200, 600, 600);
        setLayout(new BorderLayout());
        Font font = new Font("Times New Roman", Font.PLAIN, 20);

        panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout());

        toFirst = new JButton("<--");
        panel.add(toFirst, BorderLayout.NORTH);
        toSecond = new JButton("-->");
        panel.add(toSecond, BorderLayout.SOUTH);

        DefaultListModel<String> firstListModel = new DefaultListModel<>();
        firstListModel.addElement("one");
        firstListModel.addElement("two");
        firstListModel.addElement("three");
        firstListModel.addElement("four");


        DefaultListModel<String> secondListModel = new DefaultListModel<>();
        secondListModel.addElement("red");
        secondListModel.addElement("green");
        secondListModel.addElement("yellow");
        secondListModel.addElement("blue");

        firstList = new JList<>(firstListModel);
        firstList.setFont(font);
        secondList = new JList<>(secondListModel);
        secondList.setFont(font);
        add(firstList, BorderLayout.WEST);
        add(secondList, BorderLayout.EAST);


        toFirst.addActionListener(e -> {
            int count = 0;
            for (int i : secondList.getSelectedIndices()) {
                firstListModel.addElement(secondListModel.getElementAt(i - count));
                secondListModel.remove(i - count);
                count++;
            }
        });

        toSecond.addActionListener(e -> {
            int count = 0;
            for (int i : firstList.getSelectedIndices()) {
                secondListModel.addElement(firstListModel.getElementAt(i - count));
                firstListModel.remove(i - count);
                count++;
            }
        });
    }
}

























