package com.study.tdd_cleancode.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class CarRaceSetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void 요구사항1_Set_size검증() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @ParameterizedTest  //  하나의 테스트로 여러 테스트를 해볼 수 있다.
    @ValueSource(ints = {1, 2, 3})  //  literal 값의 단일 배열 지정. 매개변수화된 테스트 호출마다 단일 인수 제공
    void 요구사항2_테스트시_중복코드제거(int args) {
        assertThat(numbers)
                .contains(args);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"} //  구분자를 기준으로 CSV를 구분해서 읽는다.
            , delimiter = ':')  //  구분자 지정
    void 요구사항3_인자받아서_true_false_모두검증(String args, String expected) {
        assertThat(numbers.contains(Integer.parseInt(args)))
                .isEqualTo(Boolean.parseBoolean(expected));
    }
}
