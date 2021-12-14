package com.study.tdd_cleancode.race.three;

import com.study.tdd_cleancode.three.Car;
import com.study.tdd_cleancode.three.InputView;
import com.study.tdd_cleancode.three.Racing;
import org.junit.jupiter.api.Test;

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
        int carsCount = 4;
        int moving = 7;

        InputView input = InputView.of(carsCount, moving);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            cars.add(new Car());
        }
    }
    /*
    * 큰 범위 = 경주 = 참가자 + 경기진행
    * 중간 범위 = 참가자들 = 자동차 여러 대
    * 작은 범위 = 참가자 개개인 = 자동차 = 동작(전진) = 랜덤하게 전진하거나(true) 안하거나(false)
    * */

    @Test
    void 자동차_동작() {
        int carsCount = 4;
        int moving = 7;

        //  사용자 입력
        InputView input = InputView.of(carsCount, moving);

        //  참여 자동차 구성
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            cars.add(new Car());
        }
        //  시합 구성
        Racing race = Racing.of(moving, cars);
        
        race.start();//경주 시작
    }
}
