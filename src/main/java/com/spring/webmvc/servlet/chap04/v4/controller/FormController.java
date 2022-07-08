package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;

import java.util.Map;

public class FormController implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        return "reg_form";
    }
}
