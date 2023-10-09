package com.study.database.repository;

import com.study.database.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

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