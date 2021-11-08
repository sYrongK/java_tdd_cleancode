package com.study.tdd_cleancode.race.twostep;

public class Division {
    private final int front;
    private final int end;

    public Division(String front, String end) {
        this.front = Integer.parseInt(front);
        this.end = Integer.parseInt(end);
    }

    public int calculate() {
        return front / end;
    }
}
