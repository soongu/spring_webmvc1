package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 의존성 주입을 테스트라인에서 사용 가능
class ScoreRepositoryImplTest {

    @Autowired
    ScoreRepository repository;

    @Test
    @DisplayName("점수 정보가 데이터베이스 테이블에 삽입되어야 한다.")
    void saveTest() {
        Score s = new Score("앵앵이", 55, 33, 77);
        boolean result = repository.save(s);

        assertTrue(result);

    }

    @Test
    @DisplayName("특정 학번에 해당하는 점수 정보가 데이터베이스 테이블에서 삭제되어야 한다.")
    @Transactional
    @Rollback
    void removeTest() {

        //given
        int stuNum = 1;

        //when
        boolean result = repository.remove(stuNum);

        //then
        assertTrue(result);

    }

    @Test
    @DisplayName("모든 점수 정보를 조회해야 한다.")
    void findAllTest() {

        List<Score> scoreList = repository.findAll();

        scoreList.forEach(s -> System.out.println(s));

    }

    @Test
    @DisplayName("특정 학번에 대한 점수 정보를 조회해야 한다.")
    void findOneTest() {

        Score score = repository.findOne(5);

        System.out.println(score);

        assertEquals("앵앵이", score.getName());

    }

}