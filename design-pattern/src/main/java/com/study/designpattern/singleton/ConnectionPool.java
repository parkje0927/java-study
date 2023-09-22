package com.study.designpattern.singleton;

import java.util.Objects;

public class ConnectionPool {

    private static ConnectionPool instance = new ConnectionPool();

    //외부에서 객체 생성을 막기 위해 private 한 생성자 만든다.
    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ConnectionPool();
        }
        return instance;
    }

}
