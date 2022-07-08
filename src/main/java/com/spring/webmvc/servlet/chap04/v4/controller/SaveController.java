package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;

public class SaveController implements ControllerV4 {

    private final MemberRepository repository
            = MemoryMemberRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {

        repository.save(new Member(
                paramMap.get("account")
                , paramMap.get("password")
                , paramMap.get("userName")
        ));

        return "redirect:/";
    }
}
