package com.metro.homework.ecommerce.api.dto;

import java.util.Set;

public class OrderDTO {
    private long id;
    private Set<OrderItemDTO> orderItems;
    private float subtotal;
    private AddressDTO addressDTO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
