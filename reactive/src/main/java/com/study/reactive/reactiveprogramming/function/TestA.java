package com.study.reactive.reactiveprogramming.function;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestA {

    public static void main(String[] args) {
        log.info("함수 호출 관점 A start");
        var result = getResult();
        var nextValue = result + 5;
        assert nextValue == 5;
        log.info("함수 호출 관점 A finish");
    }

    public static int getResult() {
        log.info("getResult start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var result = 0;
        try {
            return result;
        } finally {
            log.info("getResult finish");
        }
    }
}
