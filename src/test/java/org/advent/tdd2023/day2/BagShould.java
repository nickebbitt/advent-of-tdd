package org.advent.tdd2023.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BagShould {

    @Test
    void contain_a_specific_number_of_cubes_for_each_colour() {
        Bag bag = new Bag(12, 13, 14);
        assertThat(bag.redCubes(), equalTo(12));
        assertThat(bag.greenCubes(), equalTo(13));
        assertThat(bag.blueCubes(), equalTo(14));
    }

    @Test
    void verify_if_the_sets_in_given_game_are_possible() {
        GameRecord gameRecord = new GameRecord("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");

        Bag bag = new Bag(12, 13, 14);

        assertThat(bag.verifyGameIsPossible(gameRecord), equalTo(true));
    }

    @Test
    void verify_if_the_sets_in_given_game_are_possible_2() {
        GameRecord gameRecord = new GameRecord("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");

        Bag bag = new Bag(12, 13, 14);

        assertThat(bag.verifyGameIsPossible(gameRecord), equalTo(true));
    }

    @Test
    void verify_if_the_sets_in_given_game_are_impossible_4() {
        GameRecord gameRecord = new GameRecord("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");

        Bag bag = new Bag(12, 13, 14);

        assertThat(bag.verifyGameIsPossible(gameRecord), equalTo(false));
    }

    @Test
    void verify_if_the_sets_in_given_game_are_possible_5() {
        GameRecord gameRecord = new GameRecord("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");

        Bag bag = new Bag(12, 13, 14);

        assertThat(bag.verifyGameIsPossible(gameRecord), equalTo(true));
    }

    @Test
    void verify_if_the_sets_in_given_game_are_impossible() {
        GameRecord gameRecord = new GameRecord("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");

        Bag bag = new Bag(12, 13, 14);

        assertThat(bag.verifyGameIsPossible(gameRecord), equalTo(false));
    }
}
