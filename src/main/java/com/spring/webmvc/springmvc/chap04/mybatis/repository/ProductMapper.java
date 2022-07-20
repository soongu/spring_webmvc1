package com.spring.webmvc.springmvc.chap04.mybatis.repository;

import com.spring.webmvc.springmvc.chap04.mybatis.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper  // 마이바티스 동작 인터페이스 등록
public interface ProductMapper {

    // 제품 등록
    boolean save(Product product);

    // 제품 전체 조회
    List<Product> findAll();

    // 제품 개별 조회
    Product findOne(String serialNo);

    // 제품 수정
    boolean modify(Product product);

    // 제품 삭제
    boolean remove(String serialNo);
}
