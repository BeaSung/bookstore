package com.bea.springbootmysql.controller.response;

import com.bea.springbootmysql.domain.Grade;
import com.bea.springbootmysql.domain.Member;
import lombok.Data;

@Data
public class MemberResponse {

    private Long id;
    private String name;
    private String address;
    private Grade grade;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.address = member.getAddress();
        this.grade = member.getGrade();
    }
}
