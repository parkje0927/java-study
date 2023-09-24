package com.study.effectivejava.file;

public class CustomResource implements AutoCloseable {

    public void doSomething() {
        System.out.println("doSomething");
        throw new IllegalStateException(); //추가
    }

    @Override
    public void close() throws Exception {
        System.out.println("close");
        throw new IllegalStateException(); //추가
    }
}
