package org.advent.tdd2023.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day1-input.txt");
        List<String> lines = Files.readAllLines(path);
        CalibrationDocument calibrationDocument = new CalibrationDocument(lines);
        System.out.println(calibrationDocument.sumOfValues());
    }
}
