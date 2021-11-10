package com.study.tdd_cleancode.race.twostep;

public class Subtraction extends AbstractCalculator {
    public static final String OPERATOR = "-";

    private final int front;
    private final int end;

    public Subtraction(String front, String end) {
        if (isEmpty(front) || isEmpty(end)) {
            throw new IllegalArgumentException("사칙연산에 유효하지 않은 값입니다.");
        }
        this.front = Integer.parseInt(front);
        this.end = Integer.parseInt(end);
    }

    @Override
    public boolean isSupport(String operator) {
        return OPERATOR.equals(operator);
    }

    @Override
    public int calculate() {
        return front - end;
    }
}
