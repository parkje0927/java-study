package com.study.designpattern.templatemethod;

public class Player {

    private PlayerLevel playerLevel;

    public Player() {
        playerLevel = new BeginnerLevel();
        playerLevel.showLevelMessage();
    }

    //레벨업
    public void upgradeLevel(PlayerLevel playerLevel) {
        this.playerLevel = playerLevel;
        playerLevel.showLevelMessage();
    }

    public void play(int count) {
        //플레이 횟수
        playerLevel.go(count);
    }
}
