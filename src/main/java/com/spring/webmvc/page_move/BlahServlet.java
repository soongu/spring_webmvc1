package com.spring.webmvc.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/blah")
public class BlahServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.sendRedirect("/WEB-INF/blah.jsp");

        RequestDispatcher dp
                = req.getRequestDispatcher("/WEB-INF/blah.jsp");
        dp.forward(req, resp);
    }
}
