package org.advent.tdd2023.day4;

import java.util.Arrays;
import java.util.List;

public record ScratchCardChecker(List<String> winningNumbers, List<String> actualNumbers) {

    public static ScratchCardChecker fromInput(String input) {
        String[] split = input.split("\\|"); // separate winning / actual

        return new ScratchCardChecker(extractWinningNumbers(split), extractActualNumbers(split));
    }

    private static List<String> extractActualNumbers(String[] split) {
        return Arrays.stream(split[1]
                        .trim() // remove white space around the edges
                        .split(" ")) // separate into individual numbers
                .filter(s -> !s.isEmpty()) // drop empty strings
                .toList();
    }

    private static List<String> extractWinningNumbers(String[] split) {
        return Arrays.stream(split[0]
                        .split(":")[1] // drop the Card number from winning numbers text
                        .trim() // remove white space around the edges
                        .split(" ")) // separate into individual numbers
                .toList();
    }

    public List<String> winnersFromActual() {
        return actualNumbers.stream()
                .filter(winningNumbers::contains)
                .toList();
    }

    public int points() {
        int points = 0;
        for (String winner : winnersFromActual()) {
            if (points == 0) {
                points = 1;
            } else {
                points = points * 2;
            }
        }
        return points;
    }
}
