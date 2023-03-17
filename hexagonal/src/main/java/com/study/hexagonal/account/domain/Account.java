package com.study.hexagonal.account.domain;

import java.time.LocalDateTime;

public class Account {

    /**
     * 계좌에 대한 모든 입금과 출금은 Activity 엔티티에 포착된다.
     * 모든 activity 를 한꺼번에 메모리에 올리는 것은 현명한 방법이 아니다.
     */

    private AccountId id;
    private Money baselineBalance;
    private ActivityWindow activityWindow;

    //getter, setter, constructor

    public Money calculateBalance() {
        return Money.add(
                this.baselineBalance,
                this.activityWindow.calculateBalance(this.id);
        )
    }

    public boolean withdraw(Money money, AccountId targetAccountId) {
        if (!mayWithdraw(money)) {
            return false;
        }

        Activity withdrawal = new Activity(
                this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money
        );

        this.activityWindow.addActivity(withdrawal);
        return true;
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(this.calculateBalance(), money.negate()).isPositive();
    }

    public boolean deposit(Money money, AccountId sourceAccountId) {
        Activity deposit = new Activity(
                this.id,
                sourceAccountId,
                this.id,
                LocalDateTime.now(),
                money
        );
        this.activityWindow.addActivity(deposit);
        return true;
    }
}
