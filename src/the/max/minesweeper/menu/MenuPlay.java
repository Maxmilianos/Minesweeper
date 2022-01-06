package the.max.minesweeper.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MenuPlay {

    private JFrame frame;

    private int mins = 0, size = 600;

    public MenuPlay(int m) {
        mins = m;
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Minesweeper - game");
        frame.setBounds(650, 250, size, size);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        Graphics2D graphics2D = (Graphics2D) frame.getGraphics();
        graphics2D.draw(new Line2D.Float(0, 10, 20, 10));

    }
}
