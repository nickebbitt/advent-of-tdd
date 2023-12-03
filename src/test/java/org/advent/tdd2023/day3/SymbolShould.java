package org.advent.tdd2023.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SymbolShould {

    @Test
    void create_a_symbol_with_metadata() {
        Symbol symbol = new Symbol("$", 1);
        assertThat(symbol.value(), equalTo("$"));
        assertThat(symbol.position(), equalTo(1));
    }
}