package com.spring.webmvc.servlet.chap04.v2;


import com.spring.webmvc.servlet.chap04.View;
import com.spring.webmvc.servlet.chap04.v2.controller.ControllerV2;
import com.spring.webmvc.servlet.chap04.v2.controller.FormController;
import com.spring.webmvc.servlet.chap04.v2.controller.SaveController;
import com.spring.webmvc.servlet.chap04.v2.controller.ShowController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// /mvc/v2으로 시작하는 모든 요청을 다 처리한다.
@WebServlet("/mvc/v2/*")
public class FrontControllerV2 extends HttpServlet {


    private final Map<String, ControllerV2> controllerMap
                                            = new HashMap<>();

    public FrontControllerV2() {
        controllerMap.put("/mvc/v2/join", new FormController());
        controllerMap.put("/mvc/v2/save", new SaveController());
        controllerMap.put("/mvc/v2/show", new ShowController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 현재 들어온 요청 URI를 반환
        String uri = req.getRequestURI();

        // 컨트롤러맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴
        ControllerV2 controller = controllerMap.get(uri);

        if (controller == null) {
            resp.setStatus(404); // 404 : page not found
            return;
        }

        View view = controller.process(req, resp);
        if (view != null) view.render(req, resp);

    }
}
