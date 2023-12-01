package org.advent.tdd2023.day1;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CalibrationDocument {
    private final List<CalibrationValue> calibrationValues;

    public CalibrationDocument(List<String> rawCalibrationValues) throws IOException {
        calibrationValues = rawCalibrationValues.stream().map(CalibrationValue::new).collect(Collectors.toList());

    }

    public int sumOfValues() {
        return calibrationValues.stream()
                .map(CalibrationValue::value)
                .reduce(0, Integer::sum);
    }
}
