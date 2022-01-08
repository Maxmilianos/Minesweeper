package the.max.minesweeper.utils;

import java.util.Random;

public class UtilRandom {

    private static Random random = new Random();

    public static int getRandomNumber(int min, int max) {
        return min + random.nextInt(max - min);
    }

}
