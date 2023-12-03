package org.advent.tdd2023.day2;

public class GameSet {
    private int green;
    private int red;
    private int blue;

    @Override
    public String toString() {
        return "GameSet{" +
                "green=" + green +
                ", red=" + red +
                ", blue=" + blue +
                '}';
    }

    public GameSet(String input) {
        String[] cubes = input.split(",");
        for (String cube : cubes) {
            String trim = cube.trim();
            if (trim.contains("blue")) {
                blue = extractValueForColour(trim);
            } else if (trim.contains("red")) {
                red = extractValueForColour(trim);
            } else if (trim.contains("green")) {
                green = extractValueForColour(trim);
            }
        }
    }

    private int extractValueForColour(String trim) {
        String[] strings = trim.split(" ");
        return Integer.parseInt(strings[0]);
    }

    public int blue() {
        return blue;
    }

    public int red() {
        return red;
    }

    public int green() {
        return green;
    }
}
