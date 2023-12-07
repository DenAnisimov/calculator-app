package main;

import main.service.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Приложение считает арифметические операции.\n" +
                "Примеры ввода операций: 2 + 1; 6 / 2; 2 * 2; 5 - 4.\n" +
                "Важно записывать операции именно таким образом, как указано в примерах, иначе программа вылетет. \n" +
                "Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.\n" +
                "Калькулятор умеет работать только с целыми числами.\n" +
                "Для того, чтобы завершить работу системы введите - end.");

        System.out.print("Введите операцию: ");
        String mathOperation = new Scanner(System.in).nextLine();
        System.out.println("Ответ: " + Calculator.calculateFormula(mathOperation));
    }
}