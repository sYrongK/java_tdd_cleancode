package com.study.tdd_cleancode.race.twostep;

import java.util.Arrays;

public class CalculatorResolver {

    public CalculatorResolver() {
    }

    public <T extends AbstractCalculator> int resolve(String operator, String front, String end) {
        //  TODO 이거 좀 아닌 것 같다
        T calculator = (T) Arrays.asList(new Addition(front, end), new Subtraction(front, end), new Multiply(front, end), new Division(front, end)).stream()
                .filter(o -> o.isSupport(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력한 문자와 맞는 사칙연산 연산자가 없습니다."));
        return calculator.calculate();
    }
}
