package the.max.minesweeper;

import the.max.minesweeper.menu.MenuSelect;

import java.awt.*;

public class Minesweeper {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuSelect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
