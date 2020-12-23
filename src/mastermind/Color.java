package mastermind;

import java.util.Arrays;
import java.util.Random;

enum Color {
    RED('r'),
    BLUE('b'),
    YELLOW('y'),
    ORANGE('o'),
    PINK('p'),
    GREEN('g');

    private char keyword;

    Color(char keyword) {
        this.keyword = keyword;
    }

    public static Color valueOf(char character) {
        return Arrays.stream(values()).filter(color -> color.keyword == character).findFirst().orElse(null);
    }

    public static Color getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public char getKeyword() {
        return this.keyword;
    }
}