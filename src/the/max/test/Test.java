package the.max.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        create("nope", Color.GRAY);
        create("1", Color.BLUE);
        create("2", Color.GREEN);
        for (int i = 3; i < 10; i++)
            create("" + i, Color.RED);
    }

    public static void create(String msg, Color color) {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics2D.setFont(graphics2D.getFont().deriveFont(90F));
        Font font = graphics2D.getFont();
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        graphics2D.setColor(color);
        graphics2D.drawString(msg, (bufferedImage.getWidth() - fontMetrics.stringWidth(msg)) / 2, (bufferedImage.getHeight() - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent());
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "png", new File("resources", msg + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
