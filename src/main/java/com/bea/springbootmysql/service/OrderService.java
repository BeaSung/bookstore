package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Order;

import java.util.List;

public interface OrderService {

    void order(Long memberId, Long bookId);

    List<Order> findOrders(Long memberId);
}
