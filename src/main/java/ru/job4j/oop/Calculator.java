package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int s) {
        return sum(s) + multiply(s) + minus(s) + divide(s);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultSum = Calculator.sum(10);
        System.out.println(resultSum);
        int resulMultiply = calculator.multiply(5);
        System.out.println(resulMultiply);
        int resultMinus = Calculator.minus(10);
        System.out.println(resultMinus);
        int resultDivide = calculator.divide(5);
        System.out.println(resultDivide);
        int resultSumAll = calculator.sumAllOperation(10);
        System.out.println(resultSumAll);
    }
}
