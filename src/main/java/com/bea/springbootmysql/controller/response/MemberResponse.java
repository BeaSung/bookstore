package com.bea.springbootmysql.controller.response;

import com.bea.springbootmysql.domain.Grade;
import com.bea.springbootmysql.domain.Member;
import lombok.Data;

@Data
public class MemberResponse {

    private Long id;
    private String nickName;
    private String address;
    private Grade grade;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.nickName = member.getNickname();
        this.address = member.getAddress();
        this.grade = member.getGrade();
    }
}
