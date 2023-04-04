package com.bea.springbootmysql.repository;

import com.bea.springbootmysql.domain.Order;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrderRepository extends ListCrudRepository<Order, Long> {

    List<Order> findAllById(Long id);
}
