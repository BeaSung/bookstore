package com.bea.springbootmysql.controller;

import com.bea.springbootmysql.controller.request.OrderRequest;
import com.bea.springbootmysql.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void order(@RequestBody OrderRequest request) {
        orderService.createOrder(request.getMemberId(), request.getBookId());
    }
}
