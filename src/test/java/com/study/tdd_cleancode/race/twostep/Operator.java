package com.study.tdd_cleancode.race.twostep;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", MyNumber::plus),
    MINUS("-", MyNumber::minus),
    SUBTRACT("*", MyNumber::subtract),
    DIVIDE("/", MyNumber::divide)
    ;
    private final String operator;
    private final BinaryOperator<MyNumber> expression;
    /*
    * BinaryOperator : 인자 2개와 반환값의 타입이 같을 때 사용하는 함수형 인터페이스
    * plus()가 int를 return 했다면, Function<MyNumber, Integer>이 적합했겠지만,
    * 인자가 MyNumber, return도 MyNumber이니 BinaryOperator이 적합
    * */

    Operator(String operator, BinaryOperator<MyNumber> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator search(String operator, MyNumber first, MyNumber second) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public BinaryOperator<MyNumber> getExpression() {
        return expression;
    }
}
