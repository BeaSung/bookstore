package com.bea.springbootmysql.controller.request;

import com.bea.springbootmysql.domain.Grade;
import com.bea.springbootmysql.domain.Member;
import lombok.Data;

@Data
public class SignUpRequest {

    private String nickname;
    private String address;
    private Grade grade;

    public Member convertToMember() {
        return new Member(nickname, address, grade);
    }
}
