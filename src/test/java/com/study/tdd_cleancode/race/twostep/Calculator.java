package com.study.tdd_cleancode.race.twostep;

import java.util.function.BinaryOperator;

public class Calculator {

    private MyNumber first;
    private String operator;
    private MyNumber second;

    public Calculator(String input) {
        if (input == null) {
            throw new IllegalArgumentException("계산식이 잘 못 되었습니다.");
        }
        calculateFormula(input);
    }

    public void calculateFormula(String input) {
        String[] arr = input.split(" ");
        if (arr.length < 3) {
            throw new IllegalArgumentException("계산식이 잘 못 되었습니다.");
        }
        this.first = new MyNumber(arr[0]);
        for (int i = 1; i < arr.length; i+=2) {
            operator = arr[i];
            second = new MyNumber(arr[i+1]);
            first = calculate();
        }
    }

    public MyNumber calculate() {

        BinaryOperator<MyNumber> expression = Operator
                .search(operator, first, second)
                .getExpression();
        /*
        * MyNumber 2개 인자
        * */
        return expression.apply(first, second);
    }
}
