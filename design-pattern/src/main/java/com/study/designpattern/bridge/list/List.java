package com.study.designpattern.bridge.list;

import com.study.designpattern.bridge.impl.AbstractList;

public abstract class List<T> {

    //클라이언트는 이 클래스만 보고 사용하고,
    //아래 impl 만 무엇을 선택할 것인지 결정해주면 된다.
    AbstractList<T> abstractList;

    public List(AbstractList<T> abstractList) {
        this.abstractList = abstractList;
    }

    public void add(T object) {
        abstractList.addElement(object);
    }

    public T remove(int i) {
        return abstractList.deleteElement(i);
    }

    public T get(int i) {
        return abstractList.getElement(i);
    }

    public int getSize() {
        return abstractList.getElementSize();
    }
}
