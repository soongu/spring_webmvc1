package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;

import java.util.Map;

public class FormController implements ControllerV3 {

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        return new ModelAndView("reg_form");
    }
}
