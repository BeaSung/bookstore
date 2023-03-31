package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Grade;
import com.bea.springbootmysql.domain.Member;

import java.util.List;

public interface MemberService {

    void signUp(Member member);

    Member findMember(Long memberId);

    Member findMember(String memberName);

    List<Member> findMembers(Grade memberGrade);

    List<Member> findMembers();

}
