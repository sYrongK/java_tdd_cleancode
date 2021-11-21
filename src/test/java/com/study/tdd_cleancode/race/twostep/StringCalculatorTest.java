package com.study.tdd_cleancode.race.twostep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void 덧셈() {
        String input = "2 + 3";

        Calculator calculator = new Calculator(input);
        MyNumber result = calculator.calculate();

        assertThat(result)
                .isEqualTo(new MyNumber(5));
    }

    @Test
    void 뺄셈() {
        String input = "8 - 7";

        Calculator calculator = new Calculator(input);
        MyNumber result = calculator.calculate();

        assertThat(result)
                .isEqualTo(new MyNumber(1));
    }

    @Test
    void 곱셈() {
        String input = "3 * 4";

        Calculator calculator = new Calculator(input);
        MyNumber result = calculator.calculate();

        assertThat(result)
                .isEqualTo(new MyNumber(12));
    }

    @Test
    void 나눗셈() {
        String input = "10 / 3";

        Calculator calculator = new Calculator(input);
        MyNumber result = calculator.calculate();

        assertThat(result)
                .isEqualTo(new MyNumber(3));
    }
}
