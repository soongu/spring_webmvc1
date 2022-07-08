package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;

import java.util.Map;

public interface ControllerV3 {

    /**
     *
     * @param paramMap : 요청정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌.
     * @return ModelAndView:
     *          jsp(뷰 템플릿)에게 보낼 데이터객체 (Model)과
     *          화면 처리를 위해 화면 객체(View)를 같이 처리하는 객체
     */
    ModelAndView process(Map<String, String> paramMap);
}
