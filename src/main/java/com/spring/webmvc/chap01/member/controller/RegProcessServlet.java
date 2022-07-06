package com.spring.webmvc.chap01.member.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 실질적으로 회원가입 데이터를 받아서 처리하는 서블릿
@WebServlet("/reg-process")
public class RegProcessServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");

        System.out.println("account = " + account);
        System.out.println("password = " + password);
        System.out.println("userName = " + userName);
    }
}
