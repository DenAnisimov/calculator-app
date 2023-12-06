package main.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int calculateFormula(String formula) {
        String regexCorrectFormula = "\\d+ [+\\-*\\/] \\d+";
        Pattern pattern = Pattern.compile(regexCorrectFormula);
        Matcher matcher = pattern.matcher(formula);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Wrong format. Correct format: 1 + 1, 32 / 2, 6 * 5, 2 - 2");
        }

        int firstNum = 0;
        int secondNum = 0;
        char mathOperation = ' ';

        String regexInteger = "(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])";
        pattern = Pattern.compile(regexInteger);
        matcher = pattern.matcher(formula);

        while (matcher.find()) {
            if (firstNum == 0) {
                firstNum = Integer.parseInt(matcher.group());
            }
            secondNum = Integer.parseInt(matcher.group());
        }

        String regexMathOperation = "[+\\-*\\/]";
        pattern = Pattern.compile(regexMathOperation);
        matcher = pattern.matcher(formula);

        if (matcher.find()) {
            mathOperation = matcher.group().charAt(0);
        }

        return calculate(firstNum, secondNum, mathOperation);
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
