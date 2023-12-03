package org.advent.tdd2023.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day3-input.txt");
        List<String> lines = Files.readAllLines(path);

        EngineSchematic engineSchematic = new EngineSchematic(lines);

        List<EnginePart> validEngineParts = engineSchematic.validParts();

        Integer sum = validEngineParts.stream()
                .peek(System.out::println)
                .map(EnginePart::number)
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
