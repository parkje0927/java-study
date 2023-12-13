package com.study.database.repository;

import com.study.database.domain.Member;
import com.study.database.repository.exception.MyDBException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

/**
 * 예외 누수 문제 해결
 * 체크 예외를 -> 런타임 예외로 변경
 * MemberRepository 활용
 * throws SQLException 제거
 */
@Slf4j
public class MemberRepositoryV4_1 implements MemberRepository {

    private final DataSource dataSource;

    public MemberRepositoryV4_1(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(member_id, money) values (?, ?);";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(sql); //파라미터를 바인딩할 수 있는 것

            ps.setString(1, member.getMemberId());
            ps.setInt(2, member.getMoney());
            ps.executeUpdate();
            return member;
        } catch (SQLException e) {
            //todo 아래와 같이 기존 예외 꼭 포함!!!
            throw new MyDBException(e);
        } finally {
            close(con, ps, null);
        }
    }

    @Override
    public Member findById(String memberId) {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, memberId);

            rs = ps.executeQuery();

            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else {
                throw new NoSuchElementException("member not found memberId=" + memberId);
            }
        } catch (SQLException e) {
            throw new MyDBException(e);
        } finally {
            close(con, ps, rs);
        }
    }

    @Override
    public void update(String memberId, int money) {
        String sql = "update member set money = ? where member_id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, money);
            ps.setString(2, memberId);
            int resultSize = ps.executeUpdate();

            log.info("resultSize = {}", resultSize);
        } catch (SQLException e) {
            throw new MyDBException(e);
        } finally {
            close(con, ps, null);
        }
    }

    @Override
    public void delete(String memberId) {
        String sql = "delete from member where member_id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, memberId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new MyDBException(e);
        } finally {
            close(con, ps, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);

        //트랜잭션 동기화를 사용하려면 DataSourceUtils 사용해야 한다.
        DataSourceUtils.releaseConnection(con, dataSource);
    }

    private Connection getConnection() throws SQLException {
        //트랜잭션 동기화를 사용하려면 DataSourceUtils 를 사용해야 한다.
        Connection connection = DataSourceUtils.getConnection(dataSource);
        log.info("get connection = {}, class = {}", connection, connection.getClass());
        return connection;
    }
}
