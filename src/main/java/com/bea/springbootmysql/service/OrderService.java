package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Order;

public interface OrderService {

    Order createOrder(Long memberId, Long bookId);
}
