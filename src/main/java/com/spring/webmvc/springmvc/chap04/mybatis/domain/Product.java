package com.spring.webmvc.springmvc.chap04.mybatis.domain;

import lombok.*;

import java.util.Date;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String serialNo;
    private String productName;
    private int price;
    private Date madeAt;
}
