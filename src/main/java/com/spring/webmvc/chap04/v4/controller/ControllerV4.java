package com.spring.webmvc.chap04.v4.controller;

import com.spring.webmvc.chap04.ModelAndView;

import java.util.Map;

public interface ControllerV4 {

    /**
     *
     * @param paramMap : 요청정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌.
     * @return 포워딩할 파일명 OR 리다이렉트할 경로
     */
    String process(Map<String, String> paramMap);
}
