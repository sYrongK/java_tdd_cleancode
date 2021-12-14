package com.study.tdd_cleancode.three;

/**
 * 자동차
 */
public class Car {

    private int moveCount;

    public Car() {
        this.moveCount = 0;
    }

    public void run() {
        if (RunCondition.isPass()) {
            moveCount += 1;
        }
    }
}
