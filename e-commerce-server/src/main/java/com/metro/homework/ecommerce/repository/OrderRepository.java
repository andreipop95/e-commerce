package com.metro.homework.ecommerce.repository;

import com.metro.homework.ecommerce.domain.entity.Order;
import com.metro.homework.ecommerce.domain.entity.User;
import com.metro.homework.ecommerce.domain.entity.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrdersByOrderStatusAndUser(OrderStatus orderStatus, User user);
}
