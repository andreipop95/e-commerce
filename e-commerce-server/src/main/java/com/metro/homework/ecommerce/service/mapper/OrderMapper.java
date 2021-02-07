package com.metro.homework.ecommerce.service.mapper;

import com.metro.homework.ecommerce.api.dto.OrderDTO;
import com.metro.homework.ecommerce.domain.entity.Order;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderMapper {
    private final AddressMapper addressMapper;
    private final OrderItemMapper orderItemMapper;

    public OrderMapper(AddressMapper addressMapper,
                       OrderItemMapper orderItemMapper) {
        this.addressMapper = addressMapper;
        this.orderItemMapper = orderItemMapper;
    }

    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        if (order.getDeliveryAddress() != null) {
            orderDTO.setAddressDTO(addressMapper.toDTO(order.getDeliveryAddress()));
        }
        orderDTO.setSubtotal(order.getSubtotal());
        if(order.getOrderItems() != null) {
            orderDTO.setOrderItems(
                    order.getOrderItems().stream().map(orderItemMapper::toDTO).collect(Collectors.toSet())
            );
        }
        return orderDTO;
    }
}
