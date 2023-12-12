package com.study.database.repository;

import com.study.database.domain.Member;

import java.sql.SQLException;

public interface MemberRepositoryEx {

    /**
     * JDBC 에 종속적인 인터페이스이다!!
     * 향후 JDBC 가 아닌 다른 것으로 변경 시 인터페이스 자체 변경이 필요하다.
     *
     * 런타임 예외는 이런 부분에서 자유롭다. 언체크 예외는 선언을 하지 않아도 되므로
     */

    Member save(Member member) throws SQLException;

    Member findById(String memberId) throws SQLException;

    void update(String memberId, int money) throws SQLException;

    void delete(String memberId) throws SQLException;
}
