package org.advent.tdd2023.day1;

import java.util.ArrayList;
import java.util.List;

public class CalibrationValue {
    private final String rawInput;

    public CalibrationValue(String rawInput) {
        this.rawInput = rawInput;
    }

    public int value() {
        List<String> numbers = extractNumbersFromInput();
        return calculateValueFromNumbers(numbers);
    }

    private List<String> extractNumbersFromInput() {
        List<String> numbers = new ArrayList<>();
        String[] letters = rawInput.split("");
        for (String letter : letters) {
            if (isNumeric(letter)) {
                numbers.add(letter);
            }
        }
        return numbers;
    }

    private int calculateValueFromNumbers(List<String> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            StringBuilder strValue = new StringBuilder();
            String first = numbers.get(0);
            strValue.append(first);
            String last = numbers.get(numbers.size() - 1);
            strValue.append(last);
            return Integer.parseInt(strValue.toString());
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
