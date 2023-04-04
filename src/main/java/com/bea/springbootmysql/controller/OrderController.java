package com.bea.springbootmysql.controller;

import com.bea.springbootmysql.controller.request.OrderRequest;
import com.bea.springbootmysql.controller.response.OrderResponse;
import com.bea.springbootmysql.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void order(@RequestBody OrderRequest request) {
        orderService.order(request.getMemberId(), request.getBookId());
    }

    @GetMapping
    public List<OrderResponse> getOrders(@RequestParam Long memberId) {
        return orderService.findOrders(memberId)
                .stream()
                .map(order -> new OrderResponse(order))
                .toList();
    }
}
