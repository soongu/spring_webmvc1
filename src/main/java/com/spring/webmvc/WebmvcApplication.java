package com.spring.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.spring.webmvc") // 서블릿을 모두 컨테이너에 등록한다.
public class WebmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebmvcApplication.class, args);
	}

}
