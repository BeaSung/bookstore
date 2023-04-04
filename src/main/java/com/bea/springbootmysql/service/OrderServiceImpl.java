package com.bea.springbootmysql.service;

import com.bea.springbootmysql.domain.Book;
import com.bea.springbootmysql.domain.Order;
import com.bea.springbootmysql.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final BookService bookService;
    private final DiscountPolicy discountPolicy;
    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public void order(Long memberId, Long bookId) {
        Book book = bookService.findBook(bookId);
        int discountAmount = discountPolicy.getDiscountAmount(memberId);

        Order order = new Order(memberId, bookId, book.getPrice(), discountAmount);
        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> findOrders(Long memberId) {
        return orderRepository.findAllById(memberId);
    }
}
