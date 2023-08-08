package com.study.reactive.completionstage;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletionStage;

@Slf4j
public class ThenApplyAsyncExample {

    public static void main(String[] args) throws InterruptedException {
        CompletionStage<Integer> stage = Helper.completionStage();
        stage.thenApplyAsync(value -> {
            int nextValue = value + 1;
            log.info("thenApplyAsync1 : {}", nextValue);
            return nextValue;
        }).thenApplyAsync(value -> {
            String nextValue = "result : " + value;
            log.info("thenApplyAsync2 : {}", nextValue);
            return nextValue;
        }).thenApplyAsync(value -> {
            boolean nextValue = value.equals("result : 2");
            log.info("thenApplyAsync3 : {}", nextValue);
            return nextValue;
        }).thenAcceptAsync(value -> log.info("result : {}", value));

        Thread.sleep(100);
    }

    /*
    22:01:54.058 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.chapter4.Helper -- supplyAsync
    22:01:54.157 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.chapter4.ThenApplyAsyncExample -- thenApplyAsync1 : 2
    22:01:54.160 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.chapter4.ThenApplyAsyncExample -- thenApplyAsync2 : result : 2
    22:01:54.160 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.chapter4.ThenApplyAsyncExample -- thenApplyAsync3 : true
    22:01:54.160 [ForkJoinPool.commonPool-worker-2] INFO com.study.reactive.chapter4.ThenApplyAsyncExample -- result : true
     */
}
