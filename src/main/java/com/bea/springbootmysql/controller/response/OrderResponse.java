package com.bea.springbootmysql.controller.response;

import com.bea.springbootmysql.domain.Order;

public class OrderResponse {

    private final Long id;

    public OrderResponse(Order order) {
        this.id = order.getId();
    }
}
