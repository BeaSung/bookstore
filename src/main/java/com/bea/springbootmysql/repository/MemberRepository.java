package com.bea.springbootmysql.repository;

import com.bea.springbootmysql.domain.Grade;
import com.bea.springbootmysql.domain.Member;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends ListCrudRepository<Member, Long> {

    List<Member> findByName(String name);

    List<Member> findByGrade(Grade grade);

    Optional<Member> findByNickname(String nickname);
}
