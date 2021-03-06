package the.max.minesweeper.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MenuSelect {

    private JFrame frame;

    public MenuSelect() {
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Minesweeper - select");
        frame.setBounds(650, 250, 600, 608);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /*JLabel test = new JLabel("");
        test.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/2.png")));
        test.setBounds(1, 1, 200, 200);
        frame.add(test);*/

        JLabel mins = new JLabel("Počet min");
        mins.setFont(new Font("Dialog", Font.BOLD, 18));
        mins.setBounds(140, 308, 100, 20);
        frame.getContentPane().add(mins);

        JTextField minsText = new JTextField("10");
        mins.setLabelFor(minsText);
        minsText.setBounds(280, 308, 100, 20);
        minsText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent event) {
                try {
                    Integer.parseInt(event.getKeyChar() + "");
                } catch (NumberFormatException e) {
                    event.consume();
                }
            }
        });
        frame.getContentPane().add(minsText);

        JLabel fields = new JLabel("Počet polí");
        fields.setFont(new Font("Dialog", Font.BOLD, 18));
        fields.setBounds(140, 338, 100, 20);
        frame.getContentPane().add(fields);

        JTextField fieldsText = new JTextField("10");
        fields.setLabelFor(fieldsText);
        fieldsText.setBounds(280, 338, 100, 20);
        fieldsText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent event) {
                try {
                    Integer.parseInt(event.getKeyChar() + "");
                } catch (NumberFormatException e) {
                    event.consume();
                }
            }
        });
        frame.getContentPane().add(fieldsText);

        JButton button = new JButton("Začít hru");
        button.setFont(new Font("Dialog", Font.BOLD, 18));
        button.setBounds(215, 428, 120, 35);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (minsText.getText().length() == 0) {
                    return;
                }
                try {
                    new MenuPlay(Integer.parseInt(minsText.getText()), Integer.parseInt(fieldsText.getText()), frame.getBounds());
                    frame.dispose();
                } catch (NumberFormatException ex) {

                }
            }
        });
        frame.getContentPane().add(button);
    }
}
