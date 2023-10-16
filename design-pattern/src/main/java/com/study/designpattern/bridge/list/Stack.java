package com.study.designpattern.bridge.list;

import com.study.designpattern.bridge.impl.AbstractList;

public class Stack<T> extends List<T> {

    public Stack(AbstractList<T> abstractList) {
        super(abstractList);
        System.out.println("Stack");
    }

    public void push(T object) {
        abstractList.insertElement(object, 0);
    }

    public T pop() {
        return abstractList.deleteElement(0);
    }
}
