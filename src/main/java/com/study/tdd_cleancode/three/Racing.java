package com.study.tdd_cleancode.three;

import java.util.List;

/**
 * 경주
 */
public class Racing {

    private int moving;
    private List<Car> cars;

    private Racing(int moving, List<Car> cars) {
        this.moving = moving;
        this.cars = cars;
    }

    public static Racing of(int moving, List<Car> cars) {
        return new Racing(moving, cars);
    }

    /**
     * 경주 시작
     */
    public void start() {
        for (int i = 0; i < moving; i++) {
            for (Car car : cars) {
                car.run();
            }
        }
    }
}
