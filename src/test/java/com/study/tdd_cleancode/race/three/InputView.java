package com.study.tdd_cleancode.race.three;

/**
 * 사용자 입력
 */
public class InputView {
    private final int cars;
    private final int moving;

    public InputView(int cars, int moving) {
        this.cars = cars;
        this.moving = moving;
    }

    public static InputView of(int cars, int moving) {
        return new InputView(cars, moving);
    }
}
