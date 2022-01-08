package the.max.minesweeper.menu;

import the.max.minesweeper.utils.UtilImage;
import the.max.minesweeper.utils.UtilRandom;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.ArrayList;

public class MenuPlay {

    private Frame frame;

    private int mins = 0, size = 600, fie = 0;

    private ArrayList<Field> fields = new ArrayList<Field>();

    public MenuPlay(int m, int f, Rectangle bounds) {
        mins = m;
        fie = f;
        initialize(bounds);
        frame.setVisible(true);
    }

    private void initialize(Rectangle bounds) {
        frame = new Frame();
        frame.setTitle("Minesweeper - game");
        frame.setBounds(bounds);
        // (size + 6) bcs to tak vychazalo, (size + 30) bcs toolbar si zere jeste neco mrdka jedka
        frame.setSize(new Dimension(size + 6, size + 29));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //frame.getContentPane().add(new Panel());
        for (int x = 0; x < fie; x++) {
            for (int y = 0; y < fie; y++) {
                if (true) {
                    Field field = new Field(x, y);
                    field.type = Type.CLASSIC;
                    fields.add(field);
                    JLabel label = new JLabel();
                    field.label = label;
                    label.setText(x + " " + y);
                    label.setText("");
                    // nějak vypočítat ty píčoviny, aby to vycházelo od okraje po okraj (nějaká rovnice)
                    int width = size / fie,
                            height = size / fie,
                            labelX = size / fie * x,
                            labelY = size / fie * y,
                            labelSize = size / fie;
                    System.out.println("x: " + x + ", y: " + y + ", width: " + width + ", height: " + height + ", labelX: " + labelX + ", labelY: " + labelY + ", labelSize: " + labelSize);
                    label.setIcon(UtilImage.getScaledImage(new ImageIcon("resources/unknown.png"), width, height));
                    label.setBounds(labelX, labelY, labelSize, labelSize);
                    final int fX = x, fY = y;
                    label.addMouseListener(new MouseListener() {
                        /*
                        1 - leve
                        2 - prostredni
                        3 - prave
                         */
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println("Hihi j " + "x: " + fX + ", y: " + fY + ", " + e.getButton() + " " + label.getText() + " - " + e.getLocationOnScreen().toString());

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

        ArrayList<Field> cloneFields = (ArrayList<Field>) fields.clone(), mines = new ArrayList<Field>();
        for (int i = 0; i < mins; i++) {
            Field field = cloneFields.get(UtilRandom.getRandomNumber(0, cloneFields.size()));
            field.type = Type.MINE;
            field.img = "mine";
        }
    }

    public class Field {

        public int x, y;

        public JLabel label;

        public Type type;

        public String img;

        public Field(int x, int y) {
            this.x = x;
            this.y = y;
        }



    }

    public enum Type {
        MINE, CLASSIC
    }

    public enum Clicked {

    }

    public class Frame extends JFrame {
        /*public void paint(Graphics g) {
            super.paint(g);
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.draw(new Line2D.Float(0, 10, 20, 10));
            System.out.println("Oki no");
        }*/
    }

    public class Panel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int x = 0; x < fie; x++) {
                for (int y = 0; y < fie; y++) {
                    int rectX = x * (size/fie),
                        rectY = y * (size/fie),
                        width = size/fie,
                        height = size/fie;
                    g.drawRect(rectX, rectY, width, height);
                    if (x == fie-1)
                        System.out.println((rectX + width) + "");
                }
            }
        }

    }

}
