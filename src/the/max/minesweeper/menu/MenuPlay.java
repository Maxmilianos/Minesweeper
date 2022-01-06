package the.max.minesweeper.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MenuPlay {

    private Frame frame;

    private int mins = 0, size = 600, fields = 0;

    public MenuPlay(int m, int f) {
        mins = m;
        fields = f;
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new Frame();
        frame.setTitle("Minesweeper - game");
        frame.setBounds(650, 250, size, size);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        for (int x = 0; x < fields; x++) {
            for (int y = 0; y < fields; y++) {

            }
        }
    }

    public class Frame extends JFrame {
        /*public void paint(Graphics g) {
            super.paint(g);
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.draw(new Line2D.Float(0, 10, 20, 10));
            System.out.println("Oki no");
        }*/
    }

}
