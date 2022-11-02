import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.MissingFormatArgumentException;

public class Window extends JFrame {
    Series series;

    public Window(String string) {

        super(string);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame window = new JFrame("Series");
        window.setSize(600, 400);
        window.setResizable(false);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField addressItem = new JTextField("address");
        addressItem.setBounds(window.getSize().width / 2 - 250 - addressItem.getSize().width / 2, window.getSize().height / 3, 100, 30);
        window.add(addressItem);

        JTextField firstItem = new JTextField("first item");
        firstItem.setBounds(window.getSize().width / 2 - 100 - firstItem.getSize().width / 2, window.getSize().height / 3 - 50, 150, 30);
        window.add(firstItem);

        JTextField de = new JTextField("delta");
        de.setBounds(window.getSize().width / 2 - 100 - de.getSize().width / 2, window.getSize().height / 3, 150, 30);
        window.add(de);

        JTextField numOfElements = new JTextField("number of elements");
        numOfElements.setBounds(window.getSize().width / 2 - 100 - numOfElements.getSize().width / 2, window.getSize().height / 3 + 50, 150, 30);
        window.add(numOfElements);

        JRadioButton linear = new JRadioButton("Linear");
        linear.setSelected(true);
        linear.setBounds(window.getSize().width / 2 + 80 - linear.getSize().width, window.getSize().height / 2 - 100, 200, 20);
        window.add(linear);

        JRadioButton exponential = new JRadioButton("Exponential");
        exponential.setSelected(true);
        exponential.setBounds(window.getSize().width / 2 + 80 - exponential.getSize().width, window.getSize().height / 2 - 50, 200, 20);
        window.add(exponential);

        ButtonGroup group = new ButtonGroup();
        group.add(linear);
        group.add(exponential);

        JTextField seriesResult = new JTextField("Result of computing series");
        seriesResult.setBounds(window.getSize().width / 2 - 250 - seriesResult.getSize().width / 2, window.getSize().height / 2 + 50, 400, 30);
        window.add(seriesResult);

        JButton createButton = new JButton("Write");
        createButton.setBounds(window.getSize().width / 2 + 160 - createButton.getSize().width, window.getSize().height / 2 + 10, 100, 50);
        createButton.setEnabled(true);
        window.add(createButton);

        JButton showButton = new JButton("Show");
        showButton.setEnabled(true);
        showButton.setBounds(window.getSize().width / 2 + 160 - showButton.getSize().width, window.getSize().height / 2 + 70, 100, 50);
        window.add(showButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File(addressItem.getText());
                    series.save(file);
                } catch (NullPointerException | IOException exception) {
                    JOptionPane.showMessageDialog(Window.this, "File problems", exception.getMessage(), JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(Window.this, "Not correct impute data", exception.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
                createButton.setEnabled(false);
            }
        });


        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (linear.isSelected()) {
                        series = new Linear(Double.parseDouble(firstItem.getText()), Double.parseDouble(de.getText()),
                                Integer.parseInt(numOfElements.getText()));
                    } else {
                        series = new Exponential(Double.parseDouble(firstItem.getText()), Double.parseDouble(de.getText()),
                                Integer.parseInt(numOfElements.getText()));
                    }
                        seriesResult.setText(series.toString());
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(Window.this, "Not correct impute data", exception.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
                showButton.setEnabled(true);
                createButton.setEnabled(true);
            }
        });
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Window window = new Window("Series");
        window.pack();
    }
}