package com.metro.homework.ecommerce.service.impl;

import com.metro.homework.ecommerce.api.dto.AddOrderItemDTO;
import com.metro.homework.ecommerce.domain.entity.Article;
import com.metro.homework.ecommerce.domain.entity.Order;
import com.metro.homework.ecommerce.domain.entity.OrderItem;
import com.metro.homework.ecommerce.domain.entity.User;
import com.metro.homework.ecommerce.domain.entity.enums.OrderStatus;
import com.metro.homework.ecommerce.repository.ArticleRepository;
import com.metro.homework.ecommerce.repository.OrderItemRepository;
import com.metro.homework.ecommerce.repository.OrderRepository;
import com.metro.homework.ecommerce.service.ArticleStockManagementService;
import com.metro.homework.ecommerce.service.OrderItemManagementService;
import com.metro.homework.ecommerce.service.OrderService;
import com.metro.homework.ecommerce.service.UserService;
import com.metro.homework.ecommerce.service.exception.InvalidStockException;
import com.metro.homework.ecommerce.service.exception.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.metro.homework.ecommerce.service.exception.ExceptionUtils.getObjectNotFoundExceptionSupplier;

@Service
public class OrderServiceImpl implements OrderService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ArticleRepository articleRepository;
    private final OrderItemRepository orderItemRepository;
    private final ArticleStockManagementService articleStockManagementService;
    private final OrderItemManagementService orderItemManagementService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            UserService userService,
                            ArticleRepository articleRepository,
                            OrderItemRepository orderItemRepository,
                            ArticleStockManagementService articleStockManagementService,
                            OrderItemManagementService orderItemManagementService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.articleRepository = articleRepository;
        this.orderItemRepository = orderItemRepository;
        this.articleStockManagementService = articleStockManagementService;
        this.orderItemManagementService = orderItemManagementService;
    }

    @Override
    public Order getInProgressOrder() {
        logger.debug("Fetching in progress order for current user");
        User currentUser = userService.getAuthenticatedUser();

        List<Order> ordersInProgress =
                orderRepository.findOrdersByOrderStatusAndUser(OrderStatus.IN_PROGRESS, currentUser);

        if(ordersInProgress.size() > 1) {
            logger.warn("There are multiple orders in progress for the current user. Will only consider the first one");
        }

        if (ordersInProgress.size() >= 1) {
            return ordersInProgress.get(0);
        } else {
            Order order = new Order();
            order.setUser(currentUser);
            order.setOrderStatus(OrderStatus.IN_PROGRESS);

            return orderRepository.save(order);
        }
    }

    @Override
    public Order addItemToOrder(AddOrderItemDTO orderItemDTO, Long orderId) throws InvalidStockException {
        logger.debug("Adding new item to order with id " + orderId);

        Order order = orderRepository.findById(orderId)
                .orElseThrow(getObjectNotFoundExceptionSupplier(orderId, "Could not find order with id "));

        Article article = articleRepository.findById(orderItemDTO.getArticleId())
                .orElseThrow(getObjectNotFoundExceptionSupplier(orderItemDTO.getArticleId(),
                        "Could not find article with id "));

        return orderItemManagementService.addArticleIntoOrder(article, orderItemDTO.getQuantity(), order);
    }

    @Override
    public Order removeItemFromOrder(Long itemId, Long orderId) {
        logger.debug("Removing item with id " + itemId + " from order with id " + orderId);
        OrderItem orderItem = orderItemRepository.findById(itemId)
                .orElseThrow(getObjectNotFoundExceptionSupplier(itemId, "Could not find order item with id "));

        articleStockManagementService.increaseArticleStock(orderItem.getArticle().getId(), orderItem.getQuantity());

        orderItemRepository.deleteById(itemId);
        return orderRepository.findById(orderId)
                .orElseThrow(getObjectNotFoundExceptionSupplier(orderId, "Could not find order with id "));
    }
}
