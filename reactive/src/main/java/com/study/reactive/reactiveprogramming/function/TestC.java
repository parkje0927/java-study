package com.study.reactive.reactiveprogramming.function;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class TestC {

    public static void main(String[] args) {
        log.info("함수 호출 관점 C start");
        var count = 1;
        Future<Integer> result = getResult();
        while (!result.isDone()) {
            log.info("Caller 가 자신의 일을 한다. count : {}", count++);
        }
        log.info("함수 호출 관점 C finish");
    }

    public static Future<Integer> getResult() {
        var executorService = Executors.newSingleThreadExecutor();

        try {
            return executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    log.info("getResult start");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        log.error("error : {}", e);
                    }

                    var result = 0;
                    try {
                        return result;
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