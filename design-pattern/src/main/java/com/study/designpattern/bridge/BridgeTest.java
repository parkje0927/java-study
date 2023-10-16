package com.study.designpattern.bridge;

import com.study.designpattern.bridge.impl.LinkedListImpl;
import com.study.designpattern.bridge.list.Stack;

public class BridgeTest {

    /**
     * 개념부와 구현부를 분리한 패턴
     * 개녀부, 구현부 계층구조를 분리한 것, 그리고 그 사이를 브릿지
     * <p>
     * 개념부                              구현부
     * (interface) List <-------------- (abstract) AbstractList
     * stack, Queue          bridge     Array, LinkedList
     * <p>
     * 그 아래로 계속 추가될 수 있다.
     * <p>
     * - 기능과 구현의 결합도 약하므로, 기능이 구현 방식에 얽매이지 않는다.
     * - 기능의 구현 클래스를 런타임때 지정할 수도 있다.
     * - 구현이 변경되더라도 기능 클래스 부분에 대한 컴파일은 필요 없다.
     * - 기능과 구현은 독립적으로 확장되며, 클라이언트는 기능의 인터페이스를 사용하므로(List) 구체적인 구현 내용은 숨길 수 있다.
     */

    public static void main(String[] args) {
        Stack<String> linkedListStack = new Stack<String>(new LinkedListImpl<>());

        //list 꺼 쓰면 된다.
        linkedListStack.push("a");
        linkedListStack.push("b");
        linkedListStack.push("c");

        System.out.println(linkedListStack.toString());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
    }
}
