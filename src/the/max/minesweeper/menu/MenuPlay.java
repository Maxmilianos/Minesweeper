package the.max.minesweeper.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.io.File;

public class MenuPlay {

    private Frame frame;

    private int mins = 0, size = 600, fields = 0;

    private int[][] minsL = new int[][] {};

    public MenuPlay(int m, int f, Rectangle bounds) {
        mins = m;
        fields = f;
        initialize(bounds);
        frame.setVisible(true);
    }

    private void initialize(Rectangle bounds) {
        frame = new Frame();
        frame.setTitle("Minesweeper - game");
        frame.setBounds(bounds);
        frame.setSize(new Dimension(size, size));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        for (int x = 0; x < fields; x++) {
            for (int y = 0; y < fields; y++) {
                JLabel label = new JLabel();
                label.setText(x + "" + y);
                // nějak vypočítat ty píčoviny, aby to vycházelo od okraje po okraj (nějaká rovnice)
                int width = size/fields * x,
                height = size/fields * y,
                labelSize = size/fields;
                label.setIcon(new ImageIcon("hihi.jpg"));
                label.setBounds(width, height, labelSize, labelSize);
                label.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                frame.getContentPane().add(label);
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
