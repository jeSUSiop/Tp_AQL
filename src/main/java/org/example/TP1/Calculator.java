package org.example.TP1;

public class Calculator {

    public int add(int a, int b) {
        return a + b;//line
    }

    public int subtract(int a, int b) {
        return a - b;//line
    }

    public int multiply(int a, int b) {
        return a * b;//line
    }

    public int divide(int a, int b) {
        if (b == 0) {//line
            throw new ArithmeticException("Division by zero");//line
        }
        return a / b;//line
    }
}