package com.bea.springbootmysql.repository;

import com.bea.springbootmysql.domain.Grade;
import com.bea.springbootmysql.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByName(String name);

    Optional<Member> findByGrade(Grade grade);
}
