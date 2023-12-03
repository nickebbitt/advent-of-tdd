package org.advent.tdd2023.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GameRecordShould {

    @ParameterizedTest
    @MethodSource("gameRecordInputs")
    void create_new_game_from_input(String input, int expectedId, int expectedSets) {
        GameRecord gameRecord = new GameRecord(input);

        assertThat(gameRecord.id(), equalTo(expectedId));
        assertThat(gameRecord.sets().size(), equalTo(expectedSets));

    }

    private static Stream<Arguments> gameRecordInputs() {
        return Stream.of(
                Arguments.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", 1, 3),
                Arguments.of("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue", 2, 3),
                Arguments.of("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red", 3, 3),
                Arguments.of("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red", 4, 3),
                Arguments.of("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green", 5, 2)
        );
    }
}
