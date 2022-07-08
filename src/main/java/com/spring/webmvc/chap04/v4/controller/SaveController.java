package com.spring.webmvc.chap04.v4.controller;

import com.spring.webmvc.chap04.ModelAndView;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import java.util.Map;

public class SaveController implements ControllerV4 {

    private final MemberRepository repository
            = MemoryMemberRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap) {

        repository.save(new Member(
                paramMap.get("account")
                , paramMap.get("password")
                , paramMap.get("userName")
        ));

        return "redirect:/";
    }
}
