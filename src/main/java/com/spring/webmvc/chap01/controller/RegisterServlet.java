package com.spring.webmvc.chap01.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// /register-form 요청을 처리할 서블릿 클래스
// 회원 가입 양식을 보여주고~~ 회원가입 버튼을 누르면 메모리에 저장시켜줘
@WebServlet("/register-form")
public class RegisterServlet extends HttpServlet {

    // 핵심 비즈니스 로직
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 회원가입 폼을 그려야함 (SSR)
        PrintWriter w = resp.getWriter();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        w.write("<!DOCTYPE html>\n");
        w.write("<html lang='ko'>\n");
        w.write("<head>\n");
//        w.write("<meta charset='EUC-KR'>\n");
        w.write("<title>회원가입 양식</title>\n");
        w.write("<style>label { display: block; }</style>\n");

        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<form action='/reg-process' method='post'>\n");
        w.write("<label># account: <input type='text' name='account'></label>\n");
        w.write("<label># password: <input type='password' name='password'></label>\n");
        w.write("<label># username: <input type='text' name='userName'></label>\n");
        w.write("<label><button type='submit'>register</button></label>\n");



        w.write("</form>\n");

        w.write("</body>\n");
        w.write("</html>\n");

    }
}
