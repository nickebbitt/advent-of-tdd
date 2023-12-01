package org.advent.tdd2023.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalibrationDocumentShould {

    @Test
    void calculate_total_calibration_value_from_process_input() throws IOException {
        List<String> lines = Arrays.asList("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet");
        CalibrationDocument calibrationDocument = new CalibrationDocument(lines);
        assertThat(calibrationDocument.sumOfValues(), equalTo(142));
    }

    @Test
    void handle_empty_input() throws IOException {
        List<String> lines = Collections.emptyList();
        CalibrationDocument calibrationDocument = new CalibrationDocument(lines);
        assertThat(calibrationDocument.sumOfValues(), equalTo(0));
    }
}
