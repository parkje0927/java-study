package com.study.designpattern.strategy;

import com.study.designpattern.strategy.scheduler.LeastJob;
import com.study.designpattern.strategy.scheduler.PriorityAllocation;
import com.study.designpattern.strategy.scheduler.RoundRobin;
import com.study.designpattern.strategy.scheduler.Scheduler;

import java.io.IOException;

public class StrategyTest {

    /**
     * 정책이나 알고리즘을 교체하여 사용
     * 디자인 패턴의 꽃
     * <p>
     * - 클라이언트와 독립적인 다양한 알고리즘을 적용할 수 있도록 한다.
     * - 여러 정책들이 반영될 수 있도록 구현
     * - 여러 정책이 수행되어야 하는 조건들 (if-else, switch) 문이 없어질 수 있다.
     * - 인터페이스에 선언된 기능을 구현한 다양한 정책을 다른 클래스에 영향을 주지 않고 추가, 삭제할 수 있다.
     * - 각 기능에서 if-else 조건문을 구현하는 것이 아닌 정책 클래스를 선택하도록 구현하여 유지보수가 용이하다.
     * - strategy pattern 의 클래스가 작은 규모일 경우 flyweight 패턴으로 정의하는 것이 좋다.
     * <p>
     * 예시)
     * 전화 대기열 배분 방법이 이렇게 있다고 가정
     * 1) 순서대로 배분
     * 2) 짧은 대기열을 찾아 배분
     * 3) 우선 순위에 따라 배분
     */

    public static void main(String[] args) throws IOException {
        System.out.println("전화 상담 방식 선택");
        System.out.println("RoundRobin : 한 명씩 차례로 할당");
        System.out.println("LeastJob : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
        System.out.println("PriorityAllocation : 우선순위가 높은 고객에게 먼저 할당");
        //추가될 수가 있다.

        int character = System.in.read();

        Scheduler scheduler = null;
        if (character == 'r') {
            scheduler = new RoundRobin();
        } else if (character == 'l') {
            scheduler = new LeastJob();
        } else if (character == 'p') {
            scheduler = new PriorityAllocation();
        }

        scheduler.getNextCall();
        scheduler.sendCallToAgent();
    }
}
