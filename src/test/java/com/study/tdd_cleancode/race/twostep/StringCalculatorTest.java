package com.study.tdd_cleancode.race.twostep;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @ValueSource(strings = {"2 + 5 - 1 * 6 / 2"})
    void 사칙연산_isSupport_계산(String args) {
        String[] arr = args.split(" ");

        String front = arr[0];
        String operator = null;
        String end = null;

        for (int i = 1; i < arr.length; i+=2) {
            operator = arr[i];  //index  1 3 5 7 9 11
            end = arr[i+1];     //index  2 4 6 8 10 12

            AbstractCalculator calculator = OperatorType.getCalculator(operator, front, end);
            front = String.valueOf(calculator.calculate());
        }
        assertThat(Integer.parseInt(front))
                .isEqualTo(18);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 ! 5 - 1 * 6 / 2"})
    void 연산자_오류(String args) {
        String[] arr = args.split(" ");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    String front = arr[0];
                    String operator = null;
                    String end = null;

                    for (int i = 1; i < arr.length; i+=2) {
                        operator = arr[i];  //index  1 3 5 7 9 11
                        end = arr[i+1];     //index  2 4 6 8 10 12

                        AbstractCalculator calculator = OperatorType.getCalculator(operator, front, end);
                        front = String.valueOf(calculator.calculate());
                    }
                }).withMessageMatching("잘못된 연산자 입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 5 - 1 * 6 / 2"})
    void 사칙연산_전부_반복문으로_계산(String args) {
        String[] arr = args.split(" ");

        String front = arr[0];
        String operator = null;
        String end = null;

        int result = 0;
        for (int i = 1; i < arr.length; i+=2) {
            operator = arr[i];  //index  1 3 5 7 9 11
            end = arr[i+1];     //index  2 4 6 8 10 12

            if ("+".equals(operator)) {
                Addition addition = new Addition(front, end);
                result = addition.calculate();

            } else if ("-".equals(operator)) {
                Subtraction subtraction = new Subtraction(front, end);
                result = subtraction.calculate();

            } else if ("*".equals(operator)) {
                Multiply multiply = new Multiply(front, end);
                result = multiply.calculate();

            } else {
                Division division = new Division(front, end);
                result = division.calculate();
            }

            front = String.valueOf(result);
        }
        assertThat(front)
                .isEqualTo("18");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3"})
    void 덧셈(String args) {
        String[] arr = args.split(" ");

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

    @ParameterizedTest
    @ValueSource(strings = {" + 3"})
    void 덧셈_인자_null_공백_exception(String args) {
        String[] arr = args.split(" ");

        //  앞, 연산자, 뒤
        String front = arr[0];
        String operator = arr[1];
        String end = arr[2];

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    int result = 0;
                    if ("+".equals(operator)) {
                        Addition addition = new Addition(front, end);
                        result = addition.calculate();
                    }
                }).withMessageMatching("사칙연산에 유효하지 않은 값입니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    int result = 0;
                    if ("+".equals(operator)) {
                        Addition addition = new Addition(front, end);
                        result = addition.calculate();
                    }
                }).withMessageMatching("사칙연산에 유효하지 않은 값입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 - 3"})
    void 뺄셈(String args) {
        String[] arr = args.split(" ");

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

    @ParameterizedTest
    @ValueSource(strings = {"2 * 3"})
    void 곱셈(String args) {
        String[] arr = args.split(" ");

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

    @ParameterizedTest
    @ValueSource(strings = {"2 / 3"})
    void 나눗셈(String args) {
        String[] arr = args.split(" ");

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
