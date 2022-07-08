package com.spring.webmvc.servlet.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Member {

    private static int sequence; // 일련번호

    private int userNum;
    private String account;
    private String password;
    private String userName;

    public Member() {
        this.userNum = ++sequence;
    }

    public Member(String account, String password, String userName) {
        this();
        this.account = account;
        this.password = password;
        this.userName = userName;
    }
}
