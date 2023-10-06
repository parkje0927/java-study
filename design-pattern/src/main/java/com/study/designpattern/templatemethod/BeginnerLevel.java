package com.study.designpattern.templatemethod;

public class BeginnerLevel extends PlayerLevel {

    @Override
    public void run() {
        System.out.println("천천히 run");
    }

    @Override
    public void jump() {
        System.out.println("jump 불가");
    }

    @Override
    public void turn() {
        System.out.println("turn 불가");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("== beginner ==");
    }
}
