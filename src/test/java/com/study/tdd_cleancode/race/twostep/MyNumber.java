package com.study.tdd_cleancode.race.twostep;

public class MyNumber {

    private final int number;

    public MyNumber(String str) {
        validate(str);
        this.number = Integer.parseInt(str);
    }

    public MyNumber(int number) {
        this.number = number;
    }

    private void validate(String str) {
         int input = 0;
        try {
            input = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
        if (0 > input || input > 9) {
            throw new IllegalArgumentException("정수를 입력하세요.");
        }
    }

    public MyNumber plus(MyNumber other) {
        /*
        * return 값이 원시형 int라면,
        * Operator에서 Function을 쓰기 위해서, plus 메서드를 static으로 둬야 한다.
        * 객체인 MyNumber로 둘 경우, static 안 붙여도 된다.
        * 클래스가 Static 영역에 있기 때문인 듯
        * */
        return new MyNumber(this.number + other.number);
    }

    public MyNumber minus(MyNumber other) {
        return new MyNumber(this.number - other.number);
    }

    public MyNumber subtract(MyNumber other) {
        return new MyNumber(this.number * other.number);
    }

    public MyNumber divide(MyNumber other) {
        return new MyNumber(this.number / other.number);
    }

    public int getNumber() {
        return number;
    }
}
