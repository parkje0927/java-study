package com.study.designpattern.factorymethod;

public class HyundaiCarFactory extends CarFactory {

    @Override
    public Car createCar(String name) {
        if (!name.equals("Sonata")) {
            return new Sonata();
        }
        return null;
    }
}
