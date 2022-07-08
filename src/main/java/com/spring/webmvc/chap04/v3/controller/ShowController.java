package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV3 {
    private final MemberRepository repository
                    = MemoryMemberRepo.getInstance();

    @Override
    public View process(Map<String, String> paramMap) {
        List<Member> members = repository.findAll();
        // request.setAttribute("mList", members);
        return new View("members");
    }
}
