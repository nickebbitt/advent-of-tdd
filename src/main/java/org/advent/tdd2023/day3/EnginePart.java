package org.advent.tdd2023.day3;

import java.util.Objects;

public class EnginePart {
    private final int partNumber;
    private final int startPosition;
    private final int endPosition;

    public EnginePart(int partNumber, int startPosition, int endPosition) {

        this.partNumber = partNumber;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int number() {
        return partNumber;
    }

    @Override
    public String toString() {
        return "EnginePart{" +
                "partNumber=" + partNumber +
                ", startPosition=" + startPosition +
                ", endPosition=" + endPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnginePart that = (EnginePart) o;
        return partNumber == that.partNumber && startPosition == that.startPosition && endPosition == that.endPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partNumber, startPosition, endPosition);
    }

    public int startPosition() {
        return startPosition;
    }

    public int endPosition() {
        return endPosition;
    }
}
