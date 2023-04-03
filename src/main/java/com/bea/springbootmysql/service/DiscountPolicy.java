package com.bea.springbootmysql.service;

public interface DiscountPolicy {

    int getDiscountAmount(Long memberId);
}
