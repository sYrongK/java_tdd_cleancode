package com.study.tdd_cleancode.race.twostep;

import java.util.function.BinaryOperator;

/**
 * 연산
 */
public class Operator {

    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public MyNumber execute(MyNumber first, MyNumber second) {
        BinaryOperator<MyNumber> expression = Expression
                .search(operator)
                .getExpression();
        /*
         * MyNumber 2개 인자
         * */
        return expression.apply(first, second);
    }
}
