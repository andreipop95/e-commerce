package com.metro.homework.ecommerce.controller;

import com.metro.homework.ecommerce.api.OrderApi;
import com.metro.homework.ecommerce.api.dto.AddOrderItemDTO;
import com.metro.homework.ecommerce.api.dto.OrderDTO;
import com.metro.homework.ecommerce.service.OrderService;
import com.metro.homework.ecommerce.service.exception.InvalidStockException;
import com.metro.homework.ecommerce.service.exception.ObjectNotFoundException;
import com.metro.homework.ecommerce.service.mapper.OrderMapper;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService,
                           OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDTO getInProgressOrder() {
        return orderMapper.toDTO(orderService.getInProgressOrder());
    }

    @Override
    public OrderDTO addItemToOrder(AddOrderItemDTO addOrderItemDTO, Long orderId) throws InvalidStockException {
        return orderMapper.toDTO(orderService.addItemToOrder(addOrderItemDTO, orderId));
    }

    @Override
    public OrderDTO removeItemFromOrder(Long itemId, Long orderId) {
        return orderMapper.toDTO(orderService.removeItemFromOrder(itemId, orderId));
    }
}
