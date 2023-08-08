package com.study.reactive.completionstage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionallyExample {

    public static void main(String[] args) throws InterruptedException {
        Helper.completionStage()
                .thenApplyAsync(i -> {
                    log.info("thenApplyAsync1 : {}", i);
                    return i / 0;
                }).exceptionally(e -> {
                    log.info("exceptionally1 : {}", e.getMessage());
                    return 0;
                }).thenAcceptAsync(value -> {
                    log.info("thenAcceptAsync : {}", value);
                });

        Thread.sleep(100);
    }

    /*
    22:14:10.490 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.completionstage.Helper -- supplyAsync
    22:14:10.588 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.completionstage.ExceptionallyExample -- thenApplyAsync1 : 1
    22:14:10.590 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.completionstage.ExceptionallyExample -- exceptionally1 : java.lang.ArithmeticException: / by zero
    22:14:10.591 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.completionstage.ExceptionallyExample -- thenAcceptAsync : 0
     */
}
