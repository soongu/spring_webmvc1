package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;

public class RemoveController implements ControllerV4 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        // 삭제 처리
        repository.remove(Integer.parseInt(paramMap.get("userNum")));
        // 목록으로 돌아가기 ( 목록 재요청 )
        return "redirect:/mvc/v4/show";
    }
}
