package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor // final필드를 초기화해주는 생성자 선언
public class ScoreRepositoryImpl implements ScoreRepository {

    // 스프링 JDBC - JDBC Template : JDBC를 단순화
    private final JdbcTemplate template;

    @Override
    public boolean save(Score score) {
        String sql = "INSERT INTO tbl_score " +
                    "VALUES (seq_tbl_score.nextval, ?,?,?,?,?,?,?)";
        // INSERT, UPDATE, DELETE는 템플릿의 update() 메서드 활용
        return template.update(sql, score.getName(), score.getKor()
                , score.getEng(), score.getMath(), score.getTotal()
                , score.getAverage(), score.getGrade().toString()) == 1;
    }

    @Override
    public List<Score> findAll(String sort) {
        StringBuilder sql = new StringBuilder("SELECT * FROM tbl_score");

        switch (sort) {
            case "num":
                sql.append(" ORDER BY stu_num");
                break;
            case "name":
                sql.append(" ORDER BY stu_name");
                break;
            case "average":
                sql.append(" ORDER BY average DESC");
                break;
        }

        // SELECT문의 경우는 query()
//        return template.query(sql, new ScoreRowMapper());

        /*
        return template.query(sql, new RowMapper<Score>() {
            @Override
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });
         */
        return template.query(sql.toString(), (rs, rowNum) -> new Score(rs));
    }

    @Override
    public Score findOne(int stuNum) {

        String sql = "SELECT * FROM tbl_score WHERE stu_num=?";
        // 단일 건수 조회시 사용
//        return template.queryForObject(sql, new ScoreRowMapper(), stuNum);
        return template.queryForObject(sql, (rs, rowNum) -> new Score(rs), stuNum);
    }

    @Override
    public boolean remove(int stuNum) {
        String sql = "DELETE FROM tbl_score WHERE stu_num=?";
        return template.update(sql, stuNum) == 1;
    }
}
