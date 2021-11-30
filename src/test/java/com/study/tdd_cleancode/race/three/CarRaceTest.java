package com.study.tdd_cleancode.race.three;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRaceTest {

    /*
    * n대의 자동차
    * 동작 : 전진 또는 정지 (랜덤)
    * 사용자 입력 : 몇대의 자동차. 몇번 이동할지 (Scanner 사용)
    * 전진 조건 : 랜던값이 0 ~ 9 중 4이상일 경우
    * 화면 출력 : 자동차의 상태.(동작에 대한 상태이려나)
    *
    * UI 로직과 핵심 로직 구분
    * UI 로직 : InputView, ResultView 클래스
    *
    * else 예약어 쓰지 않는다. (switch/case도 사용 x)
    * */

    @Test
    void 사용자입력_InputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int moving = scanner.nextInt();

        InputView inputView = InputView.of(cars, moving);

        /*assertThat(inputView)
                .isEqualTo(InputView.of(3, 5));*/
    }

    @Test
    void 경주대기_자동차() {
        int cars = 4;
        int moving = 7;

        InputView input = InputView.of(cars, moving);

        List<Car> list = new ArrayList<>();
        for (int i = 0; i < cars; i++) {
            Car car = Car.of(moving);
        }
    }
}
