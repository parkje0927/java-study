package com.study.database.service;

import com.study.database.domain.Member;
import com.study.database.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 트랜잭션 - 트랜잭션 매니저
 */
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV3_1 {

    private final PlatformTransactionManager transactionManager;
    private final MemberRepositoryV3 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        //트랜잭션 시작
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            //비즈니스 로직
            logic(fromId, toId, money);
            transactionManager.commit(transactionStatus); //커밋
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus); //롤백
            throw new IllegalStateException(e);
        } finally {
            //트랜잭션 매니저 내부에서 정리해준다.
        }
    }

    private void logic(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);

        //오류 생성
        validation(toMember);

        memberRepository.update(toId, toMember.getMoney() + money);
    }

    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체 중 예외가 발생했습니다.");
        }
    }

    private static void release(Connection con) {
        if (con != null) {
            try {
                con.setAutoCommit(true); //커넥션 풀을 고려
                con.close();
            } catch (Exception e) {
                log.info("error", e);
            }
        }
    }
}
