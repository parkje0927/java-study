package com.study.database.service;

import com.study.database.domain.Member;
import com.study.database.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 트랜잭션 - TransactionTemplate
 */
@Slf4j
public class MemberServiceV3_2 {

    private final TransactionTemplate transactionTemplate;
    private final MemberRepositoryV3 memberRepository;

    public MemberServiceV3_2(PlatformTransactionManager transactionManager,
                             MemberRepositoryV3 memberRepository) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
        this.memberRepository = memberRepository;
    }

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        transactionTemplate.executeWithoutResult((status) -> {
            //비즈니스 로직
            try {
                logic(fromId, toId, money);
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
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
