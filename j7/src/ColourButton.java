import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ColourButton extends JFrame
        implements ActionListener {
    protected JButton b1;
    protected JButton b2;
    protected JButton b3;

    public ColourButton(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(600, 200, 800, 600);
        setResizable(false);

        b1 = new JButton("Yellow");
        b2 = new JButton("Red");
        b3 = new JButton("Blue");


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(b1);
        getContentPane().add(b2);
        getContentPane().add(b3);

        pack();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            getContentPane().setBackground(Color.YELLOW);
        }
        if (e.getSource()==b2) {
            getContentPane().setBackground(Color.RED);
        }
        if (e.getSource()==b3) {
            getContentPane().setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        ColourButton frame = new ColourButton(" ");
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}