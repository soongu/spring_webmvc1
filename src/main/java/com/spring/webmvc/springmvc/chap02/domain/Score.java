package com.spring.webmvc.springmvc.chap02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.spring.webmvc.springmvc.chap02.domain.Grade.*;

@Setter @Getter @ToString
@NoArgsConstructor
public class Score {

    // 클라이언트가 전달할 데이터
    private String name; // 학생 이름
    private int kor, eng, math; // 국, 영, 수 점수

    // 서버에서 생성하는 데이터
    private int stuNum; // 학번
    private int total; // 총점
    private double average; // 평균
    private Grade grade; // 학점

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calcTotalAndAvg();
        calcGrade();
    }

    public Score(ResultSet rs) throws SQLException {
        this.stuNum = rs.getInt("stu_num");
        this.name = rs.getString("stu_name");
        this.kor = rs.getInt("kor");
        this.eng = rs.getInt("eng");
        this.math = rs.getInt("math");
        this.total = rs.getInt("total");
        this.average = rs.getInt("average");
        this.grade = Grade.valueOf(rs.getString("grade"));
    }


    // 총점 평균 계산
    private void calcTotalAndAvg() {
        this.total = kor + eng + math;
        this.average = total / 3.0;
    }
    // 학점 계산
    private void calcGrade() {
        if (this.average >= 90) {
            this.grade = A;
        } else if (this.average >= 80) {
            this.grade = B;
        } else if (this.average >= 70) {
            this.grade = C;
        } else if (this.average >= 60) {
            this.grade = D;
        } else {
            this.grade = F;
        }
    }

}
