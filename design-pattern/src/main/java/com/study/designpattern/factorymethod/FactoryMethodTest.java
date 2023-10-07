package com.study.designpattern.factorymethod;

public class FactoryMethodTest {

    /**
     * 인스턴스 작성을 하위 클래스에게 위임
     * Template Method 패턴을 인스턴스 생성에 적용
     */

    public static void main(String[] args) {
        CarFactory carFactory = new HyundaiCarFactory();
        Car sonata = carFactory.createCar("Sonata");
        System.out.println(sonata);
    }
}
