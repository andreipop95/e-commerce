package com.metro.homework.ecommerce.service;

import com.metro.homework.ecommerce.domain.entity.Article;
import com.metro.homework.ecommerce.domain.entity.Order;
import com.metro.homework.ecommerce.service.exception.InvalidStockException;

public interface OrderItemManagementService {

    Order addArticleIntoOrder(Article article, int orderedQuantity, Order order) throws InvalidStockException;
}
