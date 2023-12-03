package org.advent.tdd2023.day2;

public class Bag {
    private final int redCubes;
    private final int greenCubes;
    private final int blueCubes;

    public Bag(int redCubes, int greenCubes, int blueCubes) {
        this.redCubes = redCubes;
        this.greenCubes = greenCubes;
        this.blueCubes = blueCubes;
    }

    public int redCubes() {
        return redCubes;
    }

    public int greenCubes() {
        return greenCubes;
    }

    public int blueCubes() {
        return blueCubes;
    }

    public boolean verifyGameIsPossible(GameRecord gameRecord) {
        boolean impossible = gameRecord.sets().stream()
                .anyMatch(set -> set.green() > greenCubes
                        || set.blue() > blueCubes
                        || set.red() > redCubes);

        return !impossible;
    }
}
