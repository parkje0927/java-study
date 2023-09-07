package com.study.effectivejava;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void stringTest() {
        String test1 = "abc";
        String test2 = new String("abc");

        String internTest1 = test1.intern();
        String internTest2 = test2.intern();

        System.out.println("internTest1 = " + internTest1);
        System.out.println("internTest2 = " + internTest2);

        //주소값 비교
        System.out.println(test1 == test2); //false

        //문자열 비교
        System.out.println(test1.equals(test2)); //true

        String test3 = "ABC";
        System.out.println(test1.equalsIgnoreCase(test3)); //true
    }
}
