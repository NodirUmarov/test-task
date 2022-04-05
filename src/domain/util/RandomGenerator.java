package domain.util;

import java.util.Random;

public class RandomGenerator {

    private static Random rnd;

    static {
        rnd = new Random();
    }

    private RandomGenerator() {}

    public static int getRandomWithExclusion(int start, int end, int... exclude) {

        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    public static int getRandom(int floor, int ceil) {
        return floor + rnd.nextInt(ceil - floor);
    }

}
