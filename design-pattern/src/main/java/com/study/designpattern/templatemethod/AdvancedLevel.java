package com.study.designpattern.templatemethod;

public class AdvancedLevel extends PlayerLevel {

    @Override
    public void run() {
        System.out.println("빠르게 run");
    }

    @Override
    public void jump() {
        System.out.println("jump 높이");
    }

    @Override
    public void turn() {
        System.out.println("turn 빠르게");
    }

    @Override
    public void fly() {
        System.out.println("fly ~~");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("== advanced ==");
    }
}
