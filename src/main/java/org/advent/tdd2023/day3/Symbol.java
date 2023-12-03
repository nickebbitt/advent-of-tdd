package org.advent.tdd2023.day3;

import java.util.Objects;

public class Symbol {
    private final String value;
    private final int position;

    public Symbol(String value, int position) {
        this.value = value;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "value='" + value + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return position == symbol.position && Objects.equals(value, symbol.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, position);
    }

    public String value() {
        return value;
    }

    public int position() {
        return position;
    }
}

