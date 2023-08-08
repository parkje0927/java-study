package com.study.reactive.completionstage;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Slf4j
public class Helper {

    @SneakyThrows
    public static CompletionStage<Integer> completionStage() {
        var future = CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync");
            return 1;
        });
        Thread.sleep(100);
        return future;
    }
}
