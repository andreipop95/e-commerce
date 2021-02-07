package com.metro.homework.ecommerce.repository;

import com.metro.homework.ecommerce.domain.entity.Article;
import com.metro.homework.ecommerce.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Optional<OrderItem> findFirstByArticle(Article article);
}
