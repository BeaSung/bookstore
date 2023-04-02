package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Grade;
import com.bea.springbootmysql.domain.Member;
import com.bea.springbootmysql.domain.exception.DuplicatedNicknameException;
import com.bea.springbootmysql.domain.exception.MemberNotFoundException;
import com.bea.springbootmysql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void signUp(Member member) {
        validateDuplicatedNickname(member.getNickname());
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId + " Member Not Found"));
    }

    @Override
    public List<Member> findMembers(String memberName) {
        return memberRepository.findByName(memberName);
    }

    @Override
    public List<Member> findMembers(Grade memberGrade) {
        return memberRepository.findByGrade(memberGrade);
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member changeNickname(Long memberId, String memberNickname) {
        validateDuplicatedNickname(memberNickname);
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId + " Member Not Found"));

        member.changeNickname(memberNickname);
        return memberRepository.save(member);
    }

    private void validateDuplicatedNickname(String nickname) {
        Optional<Member> byNickname = memberRepository.findByNickname(nickname);
        if (byNickname.isPresent()) {
            throw new DuplicatedNicknameException();
        }
    }
}
