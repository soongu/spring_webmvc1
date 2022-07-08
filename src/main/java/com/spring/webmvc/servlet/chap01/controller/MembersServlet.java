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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/members")
public class MembersServlet extends HttpServlet {

    private MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 회원 정보를 서버에서 html을 렌더링하여 응답
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html lang='ko'>\n");
        w.write("<head>\n");
//        w.write("<meta charset='EUC-KR'>\n");
        w.write("<title>회원 목록 보기</title>\n");
        w.write("<style>label { display: block; }</style>\n");

        w.write("</head>\n");
        w.write("<body>\n");

        // 회원 한명 정보당 li태그 하나씩 만들것임
        w.write("<ul>\n");

        // 회원 목록을 저장소로부터 받아와야 함.
        List<Member> memberList = repository.findAll();

        System.out.println("list.size = " + memberList.size());

        for (Member member : memberList) {
            w.write("<li>\n");
            w.write(String.format("# 회원번호: %s, 아이디: %s, 이름: %s"
                    , member.getUserNum(), member.getAccount(),
                    member.getUserName()));
            w.write("</li>\n");
        }

        w.write("</ul>\n");


        w.write("</body>\n");
        w.write("</html>\n");

    }
}
