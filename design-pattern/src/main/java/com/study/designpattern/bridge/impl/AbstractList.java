package com.study.designpattern.bridge.impl;

public interface AbstractList<T> {

    void addElement(T object);
    T deleteElement(int i);
    int insertElement(T object, int i);
    T getElement(int i);
    int getElementSize();
}
