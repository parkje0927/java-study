package com.study.reactive.chapter1.function;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Slf4j
public class TestD {

    public static void main(String[] args) {
        log.info("함수 호출 관점 D start");
        getResult(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                var nextValue = integer + 5;
                assert nextValue == 5;
            }
        });
        log.info("함수 호출 관점 D finish");
    }

    public static void getResult(Consumer<Integer> callback) {
        var executorService = Executors.newSingleThreadExecutor();

        try {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    log.info("getResult start");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        log.error("error : {}", e);
                    }

                    var result = 0;
                    try {
                        callback.accept(result);
                    } finally {
                        log.info("getResult finish");
                    }
                }
            });
        } finally {
            executorService.shutdown();
        }
    }
}