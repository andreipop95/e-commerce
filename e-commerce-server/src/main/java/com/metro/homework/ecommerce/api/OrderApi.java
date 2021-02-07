package com.metro.homework.ecommerce.api;

import com.metro.homework.ecommerce.api.dto.AddOrderItemDTO;
import com.metro.homework.ecommerce.api.dto.OrderDTO;
import com.metro.homework.ecommerce.service.exception.InvalidStockException;
import org.springframework.web.bind.annotation.*;

@RequestMapping("order")
public interface OrderApi {

    @GetMapping("/inProgressOrder")
    OrderDTO getInProgressOrder();

    @PostMapping("/addItem/{orderId}")
    OrderDTO addItemToOrder(@RequestBody AddOrderItemDTO addOrderItemDTO,
                            @PathVariable("orderId") Long orderId)throws InvalidStockException;

    @DeleteMapping("/{itemId}/{orderId}")
    OrderDTO removeItemFromOrder(@PathVariable("itemId") Long itemId,
                                 @PathVariable("orderId") Long orderId);
}
