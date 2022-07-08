package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.ModelAndView;
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
    public ModelAndView process(Map<String, String> paramMap) {
        List<Member> members = repository.findAll();
        ModelAndView mv = new ModelAndView("members");

        // request.setAttribute("mList", members);
        mv.addAttribute("mList", members);

        return mv;
    }
}