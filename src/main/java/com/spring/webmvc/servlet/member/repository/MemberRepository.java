package com.spring.webmvc.servlet.member.repository;

import com.spring.webmvc.servlet.member.model.Member;

import java.util.List;

public interface MemberRepository {

    // 회원가입 기능
    void save(Member member);

    // 전체 회원 조회 기능
    List<Member> findAll();

    // 회원 상세 조회 기능
    Member findOne(int userNum);

    // 회원 삭제 기능
    void remove(int userNum);
}
