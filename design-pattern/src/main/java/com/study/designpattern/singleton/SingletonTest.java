package com.study.designpattern.singleton;

import java.util.Calendar;

public class SingletonTest {

    /**
     * 클래스의 인스턴스는 오직 하나임을 보장
     * 이 인스턴스에 접근할 수 있는 방법을 제공하는 패턴
     * 여러 번 생성되어 각각의 값을 가질 필요가 없을 경우에 사용한다.
     *
     * DB 와 연결하는 connection 은 여러 개일 수 있지만, connection pool 은 한 개
     */

    public static void main(String[] args) {
        ConnectionPool instance1 = ConnectionPool.getInstance();
        ConnectionPool instance2 = ConnectionPool.getInstance();
        System.out.println(instance1 == instance2);

        //예시
        Calendar calendar = Calendar.getInstance();
    }
}
