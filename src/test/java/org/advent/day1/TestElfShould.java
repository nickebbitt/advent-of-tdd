package org.advent.day1;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestElfShould {

    private Elf elf;

    @BeforeEach
    void setup() {
        elf = new Elf();
    }

    @Test
    void have_zero_total_calories_when_created() {
        assertThat(elf.getTotalCalories(), equalTo(0));
    }

    @Test
    void have_1000_total_calories_after_adding_1000() {
        elf.addCalories(1000);
        assertThat(elf.getTotalCalories(), equalTo(1000));
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        Elf anotherElf = new Elf();
        anotherElf.addCalories(1000);
        assertThat(elf.compareTo(anotherElf), equalTo(1));
    }

    @Test
    void compare_zero_for_equal_elf() {
        Elf anotherElf = new Elf();
        assertThat(elf.compareTo(anotherElf), equalTo(0));
    }

    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        Elf anotherElf = new Elf();
        elf.addCalories(1000);
        assertThat(elf.compareTo(anotherElf), equalTo(-1));
    }
}
