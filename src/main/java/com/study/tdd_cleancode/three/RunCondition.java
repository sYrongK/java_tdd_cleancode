package com.study.tdd_cleancode.three;

/**
 * 전진 조건
 */
public class RunCondition {

    public static boolean isPass() {
        return RandomNumber.get() > 4;
    }
}
