package com.spring.webmvc.servlet.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/blah")
public class BlahServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.sendRedirect("/WEB-INF/blah.jsp");

        // 모델에 데이터 담기
        req.setAttribute("msg", "안뇽하세요~");
        req.setAttribute("number", 200);
//        req.setAttribute("hobbys", Arrays.asList("수영", "독서", "수면"));
        req.setAttribute("hobbys", new ArrayList<>());


        RequestDispatcher dp
                = req.getRequestDispatcher("/WEB-INF/blah.jsp");
        dp.forward(req, resp);
    }
}
