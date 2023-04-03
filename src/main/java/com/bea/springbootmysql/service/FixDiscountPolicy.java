package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_FIX_AMOUNT = 1000;
    private final MemberService memberService;

    @Transactional(readOnly = true)
    @Override
    public int getDiscountAmount(Long memberId) {
        Member member = memberService.findMember(memberId);
        if (member.isVIP()) {
            return DISCOUNT_FIX_AMOUNT;
        }
        return 0;
    }
}
