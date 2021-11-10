package com.study.tdd_cleancode.race.twostep;

public abstract class AbstractCalculator implements Calculator {

    @Override
    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
