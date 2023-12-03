package org.advent.tdd2023.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class GameSetShould {

    @ParameterizedTest
    @MethodSource("setInputs")
    void create_set_from_input(String input, int expectedBlue, int expectRed, int expectedGreen) {
        GameSet gameSet = new GameSet(input);

        assertThat(gameSet.blue(), equalTo(expectedBlue));
        assertThat(gameSet.red(), equalTo(expectRed));
        assertThat(gameSet.green(), equalTo(expectedGreen));
    }

    private static Stream<Arguments> setInputs() {
        return Stream.of(
                Arguments.of("2 green", 0, 0, 2),
                Arguments.of("2 blue", 2, 0, 0),
                Arguments.of("2 red", 0, 2, 0),
                Arguments.of("3 blue, 4 red", 3, 4, 0),
                Arguments.of("1 red, 2 green, 6 blue", 6, 1, 2),
                Arguments.of("1 blue, 2 green", 1, 0, 2),
                Arguments.of("1 blue, 2 green", 1, 0, 2)
        );
    }

}