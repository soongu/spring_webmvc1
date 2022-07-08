package com.spring.webmvc.servlet.chap04;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Model {

    private Map<String, Object> model = new HashMap<>();

    public void addAttribute(String key, Object o) {
        model.put(key, o);
    }
}
