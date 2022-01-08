package the.max.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        create("0", Color.LIGHT_GRAY);
        create("1", Color.BLUE);
        create("2", Color.GREEN);
        for (int i = 3; i < 10; i++)
            create("" + i, Color.RED);
        createMine();
        createCapture();
        createCapturedMine();
        createUnknown();
    }

    public static void create(String msg, Color color) {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.LIGHT_GRAY);
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics2D.setFont(graphics2D.getFont().deriveFont(90F));
        Font font = graphics2D.getFont();
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        graphics2D.setColor(color);
        graphics2D.drawString(msg, (bufferedImage.getWidth() - fontMetrics.stringWidth(msg)) / 2, (bufferedImage.getHeight() - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent());
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(0, 0, bufferedImage.getWidth() - 1, bufferedImage.getHeight() - 1);
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "png", new File("resources", msg + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createUnknown() {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics2D.setFont(graphics2D.getFont().deriveFont(90F));
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(0, 0, bufferedImage.getWidth() - 1, bufferedImage.getHeight() - 1);
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "png", new File("resources", "unknown.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createMine() {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.LIGHT_GRAY);
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics2D.setFont(graphics2D.getFont().deriveFont(90F));
        graphics2D.setColor(Color.BLACK);
        int size = 70;
        graphics2D.fillOval(bufferedImage.getWidth() / 2 - size / 2, bufferedImage.getHeight() / 2 - size / 2, size, size);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(0, 0, bufferedImage.getWidth() - 1, bufferedImage.getHeight() - 1);
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "png", new File("resources", "mine.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCapture() {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.LIGHT_GRAY);
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics2D.setFont(graphics2D.getFont().deriveFont(90F));
        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(55, 20, 10, 60);
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(20, 20, 50, 30);
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(30, 80, 50, 10);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(0, 0, bufferedImage.getWidth() - 1, bufferedImage.getHeight() - 1);
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "png", new File("resources", "capture.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCapturedMine() {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.LIGHT_GRAY);
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics2D.setFont(graphics2D.getFont().deriveFont(90F));
        graphics2D.setColor(Color.BLACK);
        int size = 70;
        graphics2D.fillOval(bufferedImage.getWidth() / 2 - size / 2, bufferedImage.getHeight() / 2 - size / 2, size, size);
        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(55, 20, 10, 60);
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(20, 20, 50, 30);
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(30, 80, 50, 10);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(0, 0, bufferedImage.getWidth() - 1, bufferedImage.getHeight() - 1);
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "png", new File("resources", "capturedMine.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
