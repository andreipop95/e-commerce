package com.metro.homework.ecommerce.service.mapper;

import com.metro.homework.ecommerce.api.dto.OrderItemDTO;
import com.metro.homework.ecommerce.domain.entity.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemMapper {
    private final ArticleMapper articleMapper;

    public OrderItemMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    OrderItemDTO toDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setArticleDTO(articleMapper.toDTO(orderItem.getArticle()));
        orderItemDTO.setQuantity(orderItem.getQuantity());
        return orderItemDTO;
    }
}
