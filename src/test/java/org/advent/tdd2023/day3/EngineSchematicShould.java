package org.advent.tdd2023.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class EngineSchematicShould {

    @Test
    void parse_lines_from_single_line_input() {

        List<String> inputLines = List.of("467..114..");

        EngineSchematic engineSchematic = new EngineSchematic(inputLines);

        List<EngineSchematicLine> expectedEngineSchematicLines = List.of(
                new EngineSchematicLine("467..114..", 0)
        );
        assertThat(engineSchematic.lines()).isEqualTo(expectedEngineSchematicLines);
    }

    @Test
    void parse_lines_from_multiline_line_input() {

        List<String> inputLines = List.of("467..114..", "...$.*....");

        EngineSchematic engineSchematic = new EngineSchematic(inputLines);

        List<EngineSchematicLine> expectedEngineSchematicLines = List.of(
                new EngineSchematicLine("467..114..", 0),
                new EngineSchematicLine("...$.*....", 1)
        );
        assertThat(engineSchematic.lines()).isEqualTo(expectedEngineSchematicLines);
    }

    @Test
    void extract_valid_parts() {
        List<String> inputLines = List.of(
                "467..114..",
                "...$.*....",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."
        );
        EngineSchematic engineSchematic = new EngineSchematic(inputLines);

        assertThat(engineSchematic.validParts())
                .containsExactlyInAnyOrder(
                        new EnginePart(467, 0, 3),
                        new EnginePart(114, 5, 8),
                        new EnginePart(35, 2, 4),
                        new EnginePart(633, 6, 9),
                        new EnginePart(617, 0, 3),
                        new EnginePart(592, 2, 5),
                        new EnginePart(755, 6, 9),
                        new EnginePart(664, 1, 4),
                        new EnginePart(598, 5, 8)
                );
    }

    @Test
    void extract_no_valid_parts_where_symbol_is_before_part_numbers() {
        List<String> inputLines = List.of(
                "........467..114..",
                "...$.............."
        );
        EngineSchematic engineSchematic = new EngineSchematic(inputLines);

        assertThat(engineSchematic.validParts()).isEmpty();
    }


}
