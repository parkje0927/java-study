package com.study.hexagonal.account.application;

import com.study.hexagonal.account.application.port.in.SendMoneyUseCase;
import com.study.hexagonal.account.application.port.out.LoadAccountPort;
import com.study.hexagonal.account.application.port.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort; //계좌를 불러오기 위해 아웃고잉 포트 인터페이스 호출
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort; //DB 에 계좌 상태를 업데이트하기 위해 호출


}
