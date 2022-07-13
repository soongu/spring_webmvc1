package com.spring.webmvc.springmvc.chap01;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class CoffeeController {

    // 커피 폼 요청
    @RequestMapping("/coffee/form")
    public String form() {
        log.info("/coffee/form GET Request");
        return "chap01/coffee-form";
    }

    // 커피 주문 요청
    @RequestMapping("/coffee/result")
    public String result(String menu,
                         int price,
                         Model model) {
        log.info("/coffee/result POST! - [" + menu + ", " + price + "]");

        model.addAttribute("menu", menu);
        model.addAttribute("p", price);

        return "chap01/coffee-result";
    }
}
