package com.spring.webmvc.chap04.v4.controller;

import com.spring.webmvc.chap04.Model;
import com.spring.webmvc.chap04.ModelAndView;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV4 {
    private final MemberRepository repository
                    = MemoryMemberRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        List<Member> members = repository.findAll();
        model.addAttribute("mList", members);

        return "members";
    }
}
