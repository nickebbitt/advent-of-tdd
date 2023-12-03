package org.advent.tdd2023.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EngineSchematicLine {
    private final String line;
    private final int lineNumber;

    public EngineSchematicLine(String line, int lineNumber) {
        this.line = line;
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "EngineSchematicLine{" +
                "line='" + line + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineSchematicLine that = (EngineSchematicLine) o;
        return lineNumber == that.lineNumber && Objects.equals(line, that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, lineNumber);
    }

    public List<EnginePart> potentialParts() {
        return findPotentialEngineParts();
    }

    private List<EnginePart> findPotentialEngineParts() {
        List<EnginePart> engineParts = new ArrayList<>();
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(line);
        while (m.find()) {
            int partNumber = Integer.parseInt(m.group());
            int startPosition = m.start();
            int endPosition = m.end();
            engineParts.add(
                    new EnginePart(
                            partNumber,
                            startPosition,
                            endPosition)
            );
        }
        return engineParts;
    }

    public List<Symbol> symbols() {
        return findSymbols();
    }

    private List<Symbol> findSymbols() {
        List<Symbol> symbols = new ArrayList<>();
        Pattern p = Pattern.compile("[^a-zA-Z0-9.]");
        Matcher m = p.matcher(line);
        while (m.find()) {
            String symbolChar = m.group();
            int position = m.end();
            Symbol symbol = new Symbol(
                    symbolChar,
                    position);
            symbols.add(symbol);
        }
        return symbols;
    }

    public int lineNumber() {
        return lineNumber;
    }
}
