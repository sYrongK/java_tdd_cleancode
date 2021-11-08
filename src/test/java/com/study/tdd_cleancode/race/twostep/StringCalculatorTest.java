package com.study.tdd_cleancode.race.twostep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * 문자열 사칙연산 계산기 테스트
 */
public class StringCalculatorTest {
    
    /*
    * 문자열 사칙 연산 계산기
    * 입력 문자열과 사친연산 사이에는 반드시 빈 공백 문자열이 있다.
    * 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
    * 사칙연산 계산 우선순위가 아닌 입력 값의 순서를 우선순위로 한다.
    * */

    @Test
    void 덧셈() {
        String str = "2 + 3";
        String[] arr = str.split(" ");

        //  앞, 연산자, 뒤
        String front = arr[0];
        String operator = arr[1];
        String end = arr[2];

        int result = 0;
        if ("+".equals(operator)) {
            Addition addition = new Addition(front, end);
            result = addition.calculate();
        }

        assertThat(result)
                .isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        String str = "2 - 3";
        String[] arr = str.split(" ");

        //  앞, 연산자, 뒤
        String front = arr[0];
        String operator = arr[1];
        String end = arr[2];

        int result = 0;
        if ("-".equals(operator)) {
            Subtraction subtraction = new Subtraction(front, end);
            result = subtraction.calculate();
        }

        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        String str = "2 * 3";
        String[] arr = str.split(" ");

        //  앞, 연산자, 뒤
        String front = arr[0];
        String operator = arr[1];
        String end = arr[2];

        int result = 0;
        if ("*".equals(operator)) {
            Multiply multiply = new Multiply(front, end);
            result = multiply.calculate();
        }

        assertThat(result)
                .isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        String str = "2 / 3";
        String[] arr = str.split(" ");

        //  앞, 연산자, 뒤
        String front = arr[0];
        String operator = arr[1];
        String end = arr[2];

        int result = 0;
        if ("/".equals(operator)) {
            Division division = new Division(front, end);
            result = division.calculate();
        }

        assertThat(result)
                .isEqualTo(0);
    }
}
