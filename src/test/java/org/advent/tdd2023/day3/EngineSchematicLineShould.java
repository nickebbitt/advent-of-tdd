package org.advent.tdd2023.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class EngineSchematicLineShould {

    private final int lineNumber = 1;

    @Test
    void have_a_line_number() {
        EngineSchematicLine engineSchematicLine = new EngineSchematicLine("467.......", lineNumber);
        assertThat(engineSchematicLine.lineNumber(), equalTo(1));
    }

    @Test
    void set_metadata_for_single_potential_part() {
        EngineSchematicLine engineSchematicLine = new EngineSchematicLine("467.......", lineNumber);

        List<EnginePart> expectedParts = List.of(
                new EnginePart(467, 0, 3)
        );
        assertThat(engineSchematicLine.potentialParts(), equalTo(expectedParts));
    }

    @Test
    void set_metadata_for_multiple_potential_parts() {
        EngineSchematicLine engineSchematicLine = new EngineSchematicLine("467..114..", lineNumber);

        List<EnginePart> expectedParts = List.of(
                new EnginePart(467, 0, 3),
                new EnginePart(114, 5, 8)
        );
        assertThat(engineSchematicLine.potentialParts(), equalTo(expectedParts));
    }

    @Test
    void set_metadata_for_single_symbol() {
        EngineSchematicLine engineSchematicLine = new EngineSchematicLine("...$......", lineNumber);

        List<Symbol> expectedSymbols = List.of(
                new Symbol("$", 4)
        );
        assertThat(engineSchematicLine.symbols(), equalTo(expectedSymbols));
    }

    @Test
    void set_metadata_for_multiple_symbols() {
        EngineSchematicLine engineSchematicLine = new EngineSchematicLine("...$.*....", lineNumber);

        List<Symbol> expectedSymbols = List.of(
                new Symbol("$", 4),
                new Symbol("*", 6)
        );
        assertThat(engineSchematicLine.symbols(), equalTo(expectedSymbols));
    }

    @Test
    void set_metadata_for_all_expected_symbols() {
        EngineSchematicLine engineSchematicLine = new EngineSchematicLine("$*%#/=@&+-", lineNumber);

        List<Symbol> expectedSymbols = List.of(
                new Symbol("$", 1),
                new Symbol("*", 2),
                new Symbol("%", 3),
                new Symbol("#", 4),
                new Symbol("/", 5),
                new Symbol("=", 6),
                new Symbol("@", 7),
                new Symbol("&", 8),
                new Symbol("+", 9),
                new Symbol("-", 10)
        );
        assertThat(engineSchematicLine.symbols(), equalTo(expectedSymbols));
    }
}