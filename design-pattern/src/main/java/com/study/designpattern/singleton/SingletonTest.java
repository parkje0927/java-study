package com.study.designpattern.singleton;

import java.util.Calendar;

public class SingletonTest {

    public static void main(String[] args) {
        ConnectionPool instance1 = ConnectionPool.getInstance();
        ConnectionPool instance2 = ConnectionPool.getInstance();
        System.out.println(instance1 == instance2);

        //예시
        Calendar calendar = Calendar.getInstance();
    }
}
