package com.study.designpattern.templatemethod;

public abstract class PlayerLevel {

    /**
     * run, jump, turn 등의 활동을 할 수 있음.
     */

    public abstract void run();

    public abstract void jump();

    public abstract void turn();

    public void fly() {
    }

    public abstract void showLevelMessage();

    final public void go(int count) {
        //이거는 변하면 안 되는 거라서 재정의 X -> final 로 선언해야한다.

        run();

        for (int i = 0; i < count; i++) {
            jump();
        }

        turn();

        /**
         * 훅 메소드 : abstract 로 구현하면 모든 상속 받은 클래스에서 재정의해야하지만,
         * 이 메소드는 구현할 수도 있고, 안 할 수도 있는 메소드임. => 더 확장성있는 메소드
         */
        //advanced 레벨에서만 재정의할 것이다.
        fly();
    }
}
