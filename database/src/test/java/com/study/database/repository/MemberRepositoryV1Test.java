package com.study.database.repository;

import com.study.database.domain.Member;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static com.study.database.connection.ConnectionConst.PASSWORD;
import static com.study.database.connection.ConnectionConst.URL;
import static com.study.database.connection.ConnectionConst.USERNAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach() throws Exception {
        //DriverManager 사용 => 계속 새로운 connection 을 맺는다.
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
//        repository = new MemberRepositoryV1(driverManagerDataSource);

        //HikariPool 사용
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(URL);
        hikariDataSource.setUsername(USERNAME);
        hikariDataSource.setPassword(PASSWORD);

        repository = new MemberRepositoryV1(hikariDataSource);
    }

    @Test
    void crud() throws SQLException {
        //테스트 수행 후 delete member 해줘야 한다.
        Member member = new Member("memberV1", 10000);
        repository.save(member);

        Member findMember = repository.findById("memberV1");
        log.info("findMember = {}", findMember);
        log.info("member == findMember {}", member == findMember);
        log.info("member equals findMember {}", member.equals(findMember));
        assertThat(findMember).isEqualTo(member);

        repository.update("memberV1", 20000);
        Member findMember2 = repository.findById("memberV1");
        log.info("findMember2 = {}", findMember2);
        assertThat(findMember2.getMoney()).isEqualTo(20000);

        repository.delete("memberV1");
        assertThatThrownBy(() -> repository.findById("memberV1")).isInstanceOf(NoSuchElementException.class);
    }
}