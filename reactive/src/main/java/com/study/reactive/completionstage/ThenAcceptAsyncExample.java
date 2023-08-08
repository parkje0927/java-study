package com.study.reactive.completionstage;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executors;

@Slf4j
public class ThenAcceptAsyncExample {

    public static void main(String[] args) throws InterruptedException {
        //thenAcceptAsync + 쓰레드풀 변경
        var single = Executors.newSingleThreadExecutor();
        var fixed = Executors.newFixedThreadPool(10);

        log.info("start main");

        CompletionStage<Integer> stage = Helper.completionStage();
        stage.thenAcceptAsync(i -> {
            log.info("thenAcceptAsync1 : {}", i);
        }, fixed).thenAcceptAsync(i -> {
            log.info("thenAcceptAsync2 : {}", i);
        }, single);

        log.info("finish main");
        Thread.sleep(200);

        single.shutdown();
        fixed.shutdown();
    }

    /*
    21:54:01.699 [main] INFO com.study.reactive.chapter4.Helper -- start main
    21:54:01.710 [ForkJoinPool.commonPool-worker-1] INFO com.study.reactive.chapter4.Helper -- supplyAsync
    21:54:01.818 [main] INFO com.study.reactive.chapter4.Helper -- finish main
    21:54:01.817 [pool-2-thread-1] INFO com.study.reactive.chapter4.Helper -- thenAcceptAsync1 : 1
    21:54:01.821 [pool-1-thread-1] INFO com.study.reactive.chapter4.Helper -- thenAcceptAsync2 : null
     */
}
