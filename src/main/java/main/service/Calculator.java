package main.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int calculateFormula(String formula) {
        String regexCorrectFormula = "^(?<![-.])\\b[0-9]+\\b(?!\\.[0-9]) [+\\-*\\/] (?<![-.])\\b[0-9]+\\b(?!\\.[0-9])$";
        Pattern pattern = Pattern.compile(regexCorrectFormula);
        Matcher matcher = pattern.matcher(formula);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Неверный формат. Корректный формат: 1 + 1, 6 / 2, 6 * 5, 2 - 2");
        }

        int[] numMass = new int[2];
        int firstNum = 0;
        int secondNum = 0;
        char mathOperation = ' ';

        String regexInteger = "(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])";
        pattern = Pattern.compile(regexInteger);
        matcher = pattern.matcher(formula);

        int i = 0;
        while (matcher.find()) {
            numMass[i++] = Integer.parseInt(matcher.group());
        }

        firstNum = numMass[0];
        secondNum = numMass[1];

        if (!isNumCorrect(firstNum)) {
            throw new IllegalArgumentException("Число долбыть от 1 до 10 включительно, не более.");
        }
        if (!isNumCorrect(secondNum)) {
            throw new IllegalArgumentException("Число долбыть от 1 до 10 включительно, не более.");
        }

        String regexMathOperation = "[+\\-*\\/]";
        pattern = Pattern.compile(regexMathOperation);
        matcher = pattern.matcher(formula);

        if (matcher.find()) {
            mathOperation = matcher.group().charAt(0);
        }

        return calculate(firstNum, secondNum, mathOperation);
    }

    private static boolean isNumCorrect(int num) {
        if (num >= 1 && num <= 10) {
            return true;
        }
        return false;
    }

    private static int calculate(int firstNum, int secondNum, char mathOperation) {
        switch (mathOperation) {
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '/':
                return firstNum / secondNum;
            case '*':
                return firstNum * secondNum;
            default:
                throw new IllegalArgumentException();
        }
    }
}
