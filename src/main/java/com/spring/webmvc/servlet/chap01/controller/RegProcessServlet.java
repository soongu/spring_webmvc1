package com.spring.webmvc.servlet.chap01.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 실질적으로 회원가입 데이터를 받아서 처리하는 서블릿
@WebServlet("/reg-process")
public class RegProcessServlet extends HttpServlet {

    private MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");

        //2. 회원 정보를 적절한 저장소에 저장
        Member member = new Member(account, password, userName);
        repository.save(member);

        //3. 홈 화면으로 이동 (리다이렉션)
        resp.sendRedirect("/");
    }
}
