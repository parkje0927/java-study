package com.study.designpattern.strategy.scheduler;

public interface Scheduler {

    void getNextCall();

    void sendCallToAgent();
}
