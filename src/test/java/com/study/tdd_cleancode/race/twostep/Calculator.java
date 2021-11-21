package com.study.tdd_cleancode.race.twostep;

/**
 * 계산기
 */
public class Calculator {

    private final String input;

    public Calculator(String input) {
        if (input == null) {
            throw new IllegalArgumentException("계산식이 잘 못 되었습니다.");
        }
        this.input = input;
    }

    public MyNumber calculate() {
        String[] arr = input.split(" ");
        if (arr.length < 3) {
            throw new IllegalArgumentException("계산식이 잘 못 되었습니다.");
        }
        MyNumber first = new MyNumber(arr[0]);

        for (int i = 1; i < arr.length; i+=2) {
            Operator operator = new Operator(arr[i]);
            MyNumber second = new MyNumber(arr[i + 1]);
            first = operator.execute(first, second);
        }
        return first;
    }


}
