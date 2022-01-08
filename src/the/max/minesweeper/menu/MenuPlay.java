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

    private int mins = 0, size = 600, fie = 0, marks = 10;

    private ArrayList<Field> fields = new ArrayList<Field>();

    private boolean playing = true;

    private JLabel marksLabel;

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
        // (size + 6) bcs to tak vychazalo, (size + 29) bcs toolbar si zere jeste neco jedna + 150 = marks atd
        frame.setSize(new Dimension(size + 6, size + 29 + 50));
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
                    int width = size / fie,
                            height = size / fie,
                            labelX = size / fie * x,
                            labelY = size / fie * y,
                            labelSize = size / fie;
                    label.setIcon(UtilImage.getScaledImage(new ImageIcon(getClass().getClassLoader().getResource("resources/unknown.png")), width, height));
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
                            if (!playing) return;
                            System.out.println("Hihi j " + "x: " + fX + ", y: " + fY + ", " + e.getButton() + " " + label.getText() + " - " + e.getLocationOnScreen().toString());
                            System.out.println(field.type.toString() + " - " + field.img);
                            int at = field.at, button = e.getButton();
                            if (at == 0) {
                                if (button == 1) {
                                    field.at = 1;
                                    label.setIcon(field.getIcon());
                                    if (field.type == Type.MINE) {
                                        lose();
                                    } else {
                                        checkWin();
                                    }
                                } else if (button == 3 && marks > 0) {
                                    field.at = 2;
                                    label.setIcon(UtilImage.getScaledImage(new ImageIcon(getClass().getClassLoader().getResource("resources/capture.png")), width, height));
                                    usedMark();
                                    checkWin();
                                }
                            } else if (at == 2) {
                                if (button == 3) {
                                    field.at = 0;
                                    label.setIcon(UtilImage.getScaledImage(new ImageIcon(getClass().getClassLoader().getResource("resources/unknown.png")), width, height));
                                    removedMark();
                                }
                            }
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

        ArrayList<Field> cloneFields = (ArrayList<Field>) fields.clone();
        for (int i = 0; i < mins; i++) {
            Field field = cloneFields.get(UtilRandom.getRandomNumber(0, cloneFields.size()));
            field.type = Type.MINE;
            field.img = "mine";
            cloneFields.remove(field);
        }

        for (Field field : cloneFields) {
            int x = field.x, y = field.y;
            Field[] flds = new Field[] {
                    getField(x - 1, y - 1),  getField(x, y - 1), getField(x + 1, y - 1),
                    getField(x - 1, y), null, getField(x + 1, y),
                    getField(x - 1, y + 1), getField(x, y + 1), getField(x + 1, y + 1),
                };
            int mines = 0;
            for (Field f : flds) {
                if (f != null) {
                    if (f.type == Type.MINE) {
                        mines += 1;
                    }
                }
            }
            field.img = "" + mines;
        }

        marksLabel = new JLabel(marks + " nevyužitých vlajek", SwingConstants.CENTER);
        marksLabel.setBounds(0, 600, 600, 50);
        frame.add(marksLabel);
    }

    private void removedMark() {
        if (marks >= mins) return;
        marks += 1;
        marksLabel.setText(marks + " nevyužitých vlajek");
    }

    private void usedMark() {
        if (marks <= 0) return;
        marks -= 1;
        marksLabel.setText(marks + " nevyužitých vlajek");
    }

    public Field getField(int x, int y) {
        for (Field f : fields)
            if (f.x == x && f.y == y)
                return f;
        return null;
    }

    public void lose() {
        playing = false;
        for (Field field : fields) {
            if (field.at == 2) {
                if (field.type == Type.MINE)
                    field.label.setIcon(UtilImage.getScaledImage(new ImageIcon(getClass().getClassLoader().getResource("resources/capturedmine.png")), field.label.getIcon().getIconWidth(), field.label.getIcon().getIconHeight()));
            } else {
                field.label.setIcon(field.getIcon());
            }
        }
        JOptionPane.showMessageDialog(new JFrame(), "Prohrál si, jaká to škoda :)");
        frame.dispose();
        new MenuSelect();
    }

    public void checkWin() {
        for (Field field : fields) {
            if (field.type == Type.MINE && field.at != 2) {
                return;
            }
        }
        JOptionPane.showMessageDialog(new JFrame(), "Výhral si, gratuluju :)");
        frame.dispose();
        new MenuSelect();
    }

    public class Field {

        public int x, y;

        public JLabel label;

        public Type type;

        public String img;

        /*
        0 = skryte
        1 = odhaleno
        2 = vlajka
         */
        public int at = 0;

        public Field(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Icon getIcon() {
            return UtilImage.getScaledImage(new ImageIcon(getClass().getClassLoader().getResource("resources/" + img + ".png")), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
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
