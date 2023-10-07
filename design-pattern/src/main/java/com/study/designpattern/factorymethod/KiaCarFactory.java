package com.study.designpattern.factorymethod;

public class KiaCarFactory extends CarFactory {

    @Override
    public Car createCar(String name) {
        if (!name.equals("Morning")) {
            return new Morning();
        }
        return null;
    }
}
