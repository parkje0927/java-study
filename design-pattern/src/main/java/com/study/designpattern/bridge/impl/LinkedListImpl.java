package com.study.designpattern.bridge.impl;

import java.util.LinkedList;

public class LinkedListImpl<T> implements AbstractList<T> {

    //ArrayList 도 아래와 같이 구현 가능 ArrayList 가져와서 사용

    LinkedList<T> linkedList;

    public LinkedListImpl() {
        this.linkedList = new LinkedList<T>();
    }

    @Override
    public void addElement(T object) {
        linkedList.add(object);
    }

    @Override
    public T deleteElement(int i) {
        return linkedList.remove(i);
    }

    @Override
    public int insertElement(T object, int i) {
        linkedList.add(i, object);
        return i;
    }

    @Override
    public T getElement(int i) {
        return linkedList.get(i);
    }

    @Override
    public int getElementSize() {
        return linkedList.size();
    }
}
