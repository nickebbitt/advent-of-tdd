package org.advent.tdd2023.day3;

import java.util.ArrayList;
import java.util.List;

public class EngineSchematic {
    private final List<EngineSchematicLine> lines;

    public EngineSchematic(List<String> inputLines) {
        lines = new ArrayList<>();
        for (int i = 0; i < inputLines.size(); i++) {
            this.lines.add(new EngineSchematicLine(inputLines.get(i), i));
        }
    }

    public List<EngineSchematicLine> lines() {
        return lines;
    }


    public List<EnginePart> validParts() {
        List<EnginePart> validParts = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            EngineSchematicLine thisLine = lines.get(i);
            List<EnginePart> potentialParts = thisLine.potentialParts();
            boolean valid = false;
            for (EnginePart potentialPart : potentialParts) {
                valid = isNextToSymbol(potentialPart, thisLine)
                        || isAboveSymbol(potentialPart, i)
                        || isBelowSymbol(potentialPart, i);
                if (valid) {
                    validParts.add(potentialPart);
                }
            }
        }
        return validParts;
    }

    private boolean isBelowSymbol(EnginePart potentialPart, int i) {
        if ((i > 0)) {
            EngineSchematicLine previousLine = lines.get(i - 1);
            for (Symbol symbol : previousLine.symbols()) {
                if (symbol.position() >= potentialPart.startPosition()
                        && symbol.position() <= potentialPart.endPosition() + 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAboveSymbol(EnginePart potentialPart, int i) {
        if (!(i == lines.size() - 1)) {
            EngineSchematicLine nextLine = lines.get(i + 1);
            for (Symbol symbol : nextLine.symbols()) {
                if (symbol.position() >= potentialPart.startPosition()
                        && symbol.position() <= potentialPart.endPosition() + 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isNextToSymbol(EnginePart potentialPart, EngineSchematicLine thisLine) {
        for (Symbol symbol : thisLine.symbols()) {
            if (symbol.position() == potentialPart.startPosition()
                    || symbol.position() == potentialPart.endPosition() + 1) {
                return true;
            }
        }
        return false;
    }

    public int sumOfParts() {
        return validParts().stream()
                .peek(System.out::println)
                .map(EnginePart::number)
                .reduce(0, Integer::sum);
    }
}
