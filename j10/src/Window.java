import javax.swing.*;
import java.lang.module.ModuleDescriptor;
import java.util.StringTokenizer;

public class Window extends JFrame {

    Deque<Integer> deque;
    JTextArea dequeArea;
    JTextArea dataArea;
    JList list;

    JButton clear;
    JButton front;     //получить значение первого элемента
    JButton back;      //получить значение последнего элемента
    JButton pushFront; //добавить новый элемент в начало
    JButton pushBack;  //добавить новый элемент в конец
    JButton popFront;  //удалить элемент(ы) из начала
    JButton popBack;   //удалить элемент(ы) из конца

    Window() {
        super("My Deque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(500, 400, 600, 500);
        setResizable(false);
        setLayout(null);

        deque = Deque.create();

        dequeArea = new JTextArea("Your result will be here");
        dequeArea.setBounds(getX() - 450, getY() / 2 - 100, 500, 30);
        dequeArea.setEditable(false);
        add(dequeArea);

        dataArea = new JTextArea("Write data here");
        dataArea.setBounds(getX() - 450, getY() / 2 - 50, 500, 30);
        add(dataArea);

        list = new JList<>();
        list.setBounds(getX() - 450, getY() / 2 + 100, 500, 150);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        add(list);

        front = new JButton("get first");
        front.setBounds(getX() - 450, getY() / 2 - 150, 100, 30);
        add(front);

        back = new JButton("get last");
        back.setBounds(getX() - 300, getY() / 2 - 150, 100, 30);
        add(back);

        clear = new JButton("clear");
        clear.setBounds(getX() - 150, getY() / 2 - 150, 100, 30);
        add(clear);

        pushFront = new JButton("add to the beginning");
        pushFront.setBounds(getX() - 450, getY() / 2, 220, 30);
        add(pushFront);

        pushBack = new JButton("add to the end");
        pushBack.setBounds(getX() - 200, getY() / 2, 200, 30);
        add(pushBack);

        popFront = new JButton("delete from the beginning");
        popFront.setBounds(getX() - 450, getY() / 2 + 50, 220, 30);
        add(popFront);

        popBack = new JButton("delete from the end");
        popBack.setBounds(getX() - 200, getY() / 2 + 50, 200, 30);
        add(popBack);



        front.addActionListener(e -> {
            try {
                dequeArea.setText(deque.front().toString());
                list.setModel(deque.getListModel());
            } catch (IndexOutOfBoundsException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        back.addActionListener(e -> {
            try {
                dequeArea.setText(deque.back().toString());
                list.setModel(deque.getListModel());
            } catch (IndexOutOfBoundsException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        clear.addActionListener(e -> {
            deque.clear();
            update();
        });

        pushFront.addActionListener(e -> {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(dataArea.getText());
                while (stringTokenizer.hasMoreTokens()){
                    deque.pushFront(Integer.valueOf(stringTokenizer.nextToken()));
                    update();
                }

            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        pushBack.addActionListener(e -> {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(dataArea.getText());
                while (stringTokenizer.hasMoreTokens()) {
                    deque.pushBack(Integer.valueOf(stringTokenizer.nextToken()));
                    update();
                }

            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        popFront.addActionListener(e -> {
            try {
                deque.popFront();
                update();
            }catch (IndexOutOfBoundsException exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        });
        popBack.addActionListener(e -> {
            try {
                deque.popBack();
                update();
            }catch (IndexOutOfBoundsException exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        });
    }

    public void update(){
        dequeArea.setText(deque.toString());
        list.setModel(deque.getListModel());
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.setVisible(true);
    }
}

