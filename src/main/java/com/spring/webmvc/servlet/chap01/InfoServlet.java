package com.spring.webmvc.servlet.chap01;

/*
    # 서블릿: http 요청과 응답 데이터를 쉽게 처리할
            수 있도록 도와주는 자바의 API
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {



    public InfoServlet() {
        System.out.println("\n\n\n\nInfoServlet constructor call!\n\n\n\n");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("info 요청이 들어옴!!");

//        System.out.println("connected IP address: " + req.getRemoteAddr());
//        System.out.println("hobby: " + req.getParameter("hobby"));

        // 요청 정보 받기
        double height = Double.parseDouble(req.getParameter("height"));
        double weight = Double.parseDouble(req.getParameter("weight"));


        // 응답 정보 생성하기
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<html>");
        w.write("<body>");
        double bmi = calcBMI(height, weight);
        w.write("  <h1>님의 체질량지수는 " + bmi + "입니다!?</h1>");

        if (bmi > 25.0) {
            w.write("<h2>과체중입니다.</h2>");
        } else if (bmi < 18.5) {
            w.write("<h2>저체중입니다.</h2>");
        } else {
            w.write("<h2>정상 체중입니다.</h2>");
        }

        w.write("</body>");
        w.write("</html>");

    }

    @Override
    public void destroy() {
        System.out.println("\n\n\nservlet disappeared!!\n\n\n");
    }

    private double calcBMI(double cm, double kg) {
        double m = cm / 100;
        double bmi = kg / (m * m);
        return bmi;
    }
}
