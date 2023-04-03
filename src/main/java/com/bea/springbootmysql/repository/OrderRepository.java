package com.bea.springbootmysql.repository;

import com.bea.springbootmysql.domain.Order;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<Order, Long> {
}
