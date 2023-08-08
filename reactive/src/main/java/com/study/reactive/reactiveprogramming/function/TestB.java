package com.study.reactive.reactiveprogramming.function;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class TestB {

    public static void main(String[] args) {
        log.info("함수 호출 관점 B start");
        getResult(num -> {
            var nextValue = num + 5;
            assert nextValue == 5;
        });
        log.info("함수 호출 관점 B finish");
    }

    public static void getResult(Consumer<Integer> consumer) {
        log.info("getResult start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var result = 0;
        consumer.accept(result);
        log.info("getResult finish");
    }
}
