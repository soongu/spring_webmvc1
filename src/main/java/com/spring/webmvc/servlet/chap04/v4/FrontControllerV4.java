package com.spring.webmvc.servlet.chap04.v4;


import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.chap04.ModelAndView;
import com.spring.webmvc.servlet.chap04.v4.controller.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

// /mvc/v4으로 시작하는 모든 요청을 다 처리한다.
@WebServlet("/mvc/v4/*")
public class FrontControllerV4 extends HttpServlet {


    private final Map<String, ControllerV4> controllerMap
                                            = new HashMap<>();

    public FrontControllerV4() {
        controllerMap.put("/mvc/v4/join", new FormController());
        controllerMap.put("/mvc/v4/save", new SaveController());
        controllerMap.put("/mvc/v4/show", new ShowController());
        controllerMap.put("/mvc/v4/member", new FindOneController());
        controllerMap.put("/mvc/v4/remove", new RemoveController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        // 현재 들어온 요청 URI를 반환
        String uri = req.getRequestURI();

        // 컨트롤러맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴
        ControllerV4 controller = controllerMap.get(uri);

        if (controller == null) {
            resp.setStatus(404); // 404 : page not found
            return;
        }

        // 요청 파라미터(query parameter)를 전부 읽어서 하위 컨트롤러들에게 보내줌
        // key: 파라미터의 key, value: 파라미터의 value
        Map<String, String> paramMap = createParamMap(req);

        Model model = new Model(); // 모델객체 생성해서 하위 컨트롤러에게 전달
        String viewName = controller.process(paramMap, model);
        ModelAndView mv = new ModelAndView(viewName);
        mv.setModel(model); // 모델앤뷰 객체에 데이터 모델 저장.

        // 모델데이터를 jsp로 전송
        modelToView(req, mv);

        // 화면 렌더링
        mv.render(req, resp);

    }

    private void modelToView(HttpServletRequest req, ModelAndView mv) {
        Map<String, Object> model = mv.getModel();
        for (String key : model.keySet()) {
            req.setAttribute(key, model.get(key));
        }
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = req.getParameter(key);
            paramMap.put(key, value);
        }
        return paramMap;
    }
}
