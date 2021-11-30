package com.study.tdd_cleancode.race.three;

/**
 * 자동차
 */
public class Car {
    
    private final int moving;// 동작 횟수

    public Car(int moving) {
        this.moving = moving;
    }

    public static Car of(int moving) {
        return new Car(moving);
    }
}
