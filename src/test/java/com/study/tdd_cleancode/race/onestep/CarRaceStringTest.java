package com.study.tdd_cleancode.race.onestep;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarRaceStringTest {
    //  TODO 요구사항 1
    //  TODO 요구사항 2
    //  TODO 요구사항 3


    @Test
    void 요구사항1_split검증() {
        String numbers = "1,2";
        assertThat(numbers.split(","))
                .contains("1", "2");

        numbers = "1";
        assertThat(numbers.split(","))
                .containsOnly("1");

        assertThat(numbers.split(","))
                .containsExactly("1");
    }

    @Test
    void 요구사항2_substring() {
        String text = "(1,2)";
        assertThat(text.substring(1,4))
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt_Exception_검증")
    void 요구사항3_charAt() {
        assertThatThrownBy(() -> {
            try {
                "abc".charAt(4);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("Index: 2, Size: 2");
            }
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(4);
                }).withMessageMatching("String index out of range: 4");

//        assertThatIllegalArgumentException()
    }
}
