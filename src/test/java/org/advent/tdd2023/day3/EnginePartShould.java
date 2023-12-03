package org.advent.tdd2023.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EnginePartShould   {

    @Test
    void hold_properties_of_a_part() {
        EnginePart enginePart = new EnginePart(467, 1, 3);

        assertThat(enginePart.number(), equalTo(467));
        assertThat(enginePart.startPosition(), equalTo(1));
        assertThat(enginePart.endPosition(), equalTo(3));
    }
}
