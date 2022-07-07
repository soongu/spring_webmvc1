package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import java.util.Map;

public class SaveController implements ControllerV3 {

    private final MemberRepository repository
            = MemoryMemberRepo.getInstance();

    @Override
    public View process(Map<String, String> paramMap) {
        String account = paramMap.get("account");
        String password = paramMap.get("password");
        String userName = paramMap.get("userName");

        Member member = new Member(account, password, userName);
        repository.save(member);

        // response.sendRedirect("/");

        return null;
    }
}
