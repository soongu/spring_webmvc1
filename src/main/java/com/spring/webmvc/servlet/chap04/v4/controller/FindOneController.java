package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;

public class FindOneController implements ControllerV4 {

    private MemberRepository repository
            = MemoryMemberRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        Member member = repository.findOne(Integer.parseInt(paramMap.get("userNum")));
        model.addAttribute("m", member);
        return "detail";
    }
}
