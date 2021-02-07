package com.metro.homework.ecommerce.service;

import com.metro.homework.ecommerce.api.dto.AddOrderItemDTO;
import com.metro.homework.ecommerce.domain.entity.Order;
import com.metro.homework.ecommerce.service.exception.InvalidStockException;
import com.metro.homework.ecommerce.service.exception.ObjectNotFoundException;

public interface OrderService {

    Order getInProgressOrder();

    Order addItemToOrder(AddOrderItemDTO orderItemDTO, Long orderId) throws InvalidStockException;

    Order removeItemFromOrder(Long itemId, Long orderId);
}
