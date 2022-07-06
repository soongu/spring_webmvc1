package com.spring.webmvc.chap01.member.repository;

import com.spring.webmvc.chap01.member.model.Member;

import java.util.List;

public interface MemberRepository {

    // 회원가입 기능
    void save(Member member);

    // 전체 회원 조회 기능
    List<Member> findAll();
}
