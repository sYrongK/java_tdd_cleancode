package com.study.tdd_cleancode.race.twostep;

public enum OperatorType {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLY("*"),
    DIVISION("/")
    ;

    private String str;

    OperatorType(String str) {
        this.str = str;
    }

    public static AbstractCalculator getCalculator(String operator, String front, String end) {

        if (ADDITION.str.equals(operator)) {
            return new Addition(front, end);
        } else if (SUBTRACTION.str.equals(operator)) {
            return new Subtraction(front, end);
        } else if (MULTIPLY.str.equals(operator)) {
            return new Multiply(front, end);
        } else if (DIVISION.str.equals(operator)) {
            return new Division(front, end);
        } else {
            throw new IllegalArgumentException("잘못된 연산자 입니다.");
        }
    }
}
