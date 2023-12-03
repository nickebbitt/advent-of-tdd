package org.advent.tdd2023.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {
    /*

    Each game is listed with its ID number (like the 11 in Game 11: ...)
    followed by a semicolon-separated list of subsets of cubes that were
    revealed from the bag (like 3 red, 5 green, 4 blue).

    Puzzle input:

    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green

    Example parsing:

    id = "Game 1:"
    sets:
        "3 blue, 4 red;"
        "2 green, 6 blue;"
        "2 green"

     */

    public static void main(String[] args) throws IOException {

        Bag bag = new Bag(12, 13, 14);

        Path path = Path.of("src/main/resources/day2-input.txt");
        List<String> lines = Files.readAllLines(path);

        List<GameRecord> possibleGames = lines.stream().map(GameRecord::new)
                .filter(bag::verifyGameIsPossible)
                .peek(gameRecord -> System.out.println(gameRecord.toString()))
                .toList();

        Integer sumOfIds = possibleGames.stream().map(GameRecord::id)
                .reduce(0, Integer::sum);

        System.out.println(sumOfIds);

    }
}
