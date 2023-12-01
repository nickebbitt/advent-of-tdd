package org.advent.tdd2023.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class CalibrationValueShould {

    @ParameterizedTest()
    @MethodSource("calibrationInputs")
    void calculate_value_from_input(String input, int expected) {
        CalibrationValue calibrationValue = new CalibrationValue(input);

        assertThat(calibrationValue.value(), equalTo(expected));
    }

    private static Stream<Arguments> calibrationInputs() {
        return Stream.of(
                Arguments.of("1abc2", 12),
                Arguments.of("pqr3stu8vwx", 38),
                Arguments.of("a1b2c3d4e5f", 15),
                Arguments.of("treb7uchet", 77),
                Arguments.of("qlljdqcbeight", 0)
        );
    }

    @Test
    void verify_that_a_character_is_numeric() {
        assertThat(CalibrationValue.isNumeric("1"), equalTo(true));
    }

    @Test
    void verify_that_a_character_is_not_numeric() {
        assertThat(CalibrationValue.isNumeric("a"), equalTo(false));
    }

    @Test
    void verify_that_null_is_not_numeric() {
        assertThat(CalibrationValue.isNumeric(null), equalTo(false));
    }

}