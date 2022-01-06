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

    private boolean logging = false;

    public MenuSelect() {
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Minesweeper - select");
        frame.setBounds(650, 250, 600, 608);
        frame.setMinimumSize(new Dimension(600, 608));
        frame.setMaximizedBounds(new Rectangle(650, 250, 600, 608));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        /*JLabel img = new JLabel(Centrum.getImage("/img/splotchy.tech.png"));
        int sizeX = 600, sizeY = 208;
        img.setBounds(300 - (sizeX/2), 0, sizeX, sizeY);
        frame.getContentPane().add(img);

		JLabel creator = new JLabel("Created by The_MaxCZ");
		creator.setFont(new Font("Dialog", Font.BOLD, 12));
		creator.setHorizontalAlignment(SwingConstants.RIGHT);
		creator.setBounds(400, 578, 190, 20);
		frame.getContentPane().add(creator);*/

        JPanel panel = new JPanel();
        panel.setBounds(100, 308, 400, 200);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel nickname = new JLabel("Nickname");
        nickname.setFont(new Font("Dialog", Font.BOLD, 18));
        nickname.setBounds(40, 20, 100, 20);
        panel.add(nickname);

        JTextField nicknameText = new JTextField();
        nicknameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent event) {
                if (nicknameText.getText().length() >= 15)
                    event.consume();
            }
        });
        nickname.setLabelFor(nicknameText);
        nicknameText.setFont(new Font("Dialog", Font.PLAIN, 18));
        nicknameText.setBounds(180, 20, 170, 20);
        panel.add(nicknameText);
        nicknameText.setColumns(10);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("Dialog", Font.BOLD, 18));
        password.setBounds(40, 60, 100, 20);
        panel.add(password);

        JPasswordField passwordText = new JPasswordField();
        password.setLabelFor(passwordText);
        passwordText.setFont(new Font("Dialog", Font.PLAIN, 18));
        passwordText.setBounds(180, 60, 170, 20);
        panel.add(passwordText);
    }
}
