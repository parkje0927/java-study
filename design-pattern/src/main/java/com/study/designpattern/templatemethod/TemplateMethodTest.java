package com.study.designpattern.templatemethod;

public class TemplateMethodTest {

    /**
     * 프레임워크에서 많이 사용
     * 상위 클래스에서는 전체적인 흐름을 구현하고(이 흐름은 변하면 안된다.)
     * 구체적인 처리는 하위 클래스에 위임
     * <p>
     * 프레임워크 : 제어권을 프레임워크가 가진다.
     * 라이브러리 : 제어권은 개발자가 가진다. 필요한 것을 가져다가 쓴다.
     * <p>
     * 훅 오퍼레이션을 사용할 수 있다.
     * 코드 재사용을 위한 시나리오
     */

    public static void main(String[] args) {
        Player player = new Player();

        player.play(1);

        player.upgradeLevel(new AdvancedLevel());

        player.play(5);
    }
}
