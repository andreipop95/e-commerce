package com.metro.homework.ecommerce.service.impl;

import com.metro.homework.ecommerce.domain.entity.Article;
import com.metro.homework.ecommerce.domain.entity.Order;
import com.metro.homework.ecommerce.domain.entity.OrderItem;
import com.metro.homework.ecommerce.repository.OrderItemRepository;
import com.metro.homework.ecommerce.repository.OrderRepository;
import com.metro.homework.ecommerce.service.ArticleStockManagementService;
import com.metro.homework.ecommerce.service.OrderItemManagementService;
import com.metro.homework.ecommerce.service.exception.InvalidStockException;
import com.metro.homework.ecommerce.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemManagementServiceImpl implements OrderItemManagementService {

    private final ArticleStockManagementService articleStockManagementService;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderItemManagementServiceImpl(ArticleStockManagementService articleStockManagementService,
                                          OrderRepository orderRepository,
                                          OrderItemRepository orderItemRepository) {
        this.articleStockManagementService = articleStockManagementService;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Order addArticleIntoOrder(Article article, int orderedQuantity, Order order) throws InvalidStockException {
        articleStockManagementService.decreaseArticleStock(article.getId(), orderedQuantity);
        Optional<OrderItem> orderItemOptional = orderItemRepository.findFirstByArticle(article);

        if(orderItemOptional.isPresent()) {
            OrderItem orderItem = orderItemOptional.get();
            orderItem.setQuantity(orderItem.getQuantity() + orderedQuantity);
            orderItemRepository.save(orderItem);

            Optional<Order> orderOptional = orderRepository.findById(order.getId());
            if (orderOptional.isEmpty()) {
                throw new ObjectNotFoundException("Could not find order with id " + order.getId());
            } else {
                return orderOptional.get();
            }
        } else {
            OrderItem orderItem = new OrderItem();
            orderItem.setArticle(article);
            orderItem.setQuantity(orderedQuantity);
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);
            return orderRepository.save(order);
        }
    }
}
