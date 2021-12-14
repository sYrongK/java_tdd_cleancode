package com.study.tdd_cleancode.three;

import java.util.Random;

public class RandomNumber {

    private final static int LIMIT = 9;

    /*private RandomNumber(int limit) {
        this.limit = limit;
    }

    public static RandomNumber of(int limit) {
        return new RandomNumber(limit);
    }*/

    public static int get() {
        return new Random().nextInt(LIMIT);
    }
}
