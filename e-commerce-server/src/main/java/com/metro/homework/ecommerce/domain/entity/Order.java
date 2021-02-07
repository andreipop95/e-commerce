package com.metro.homework.ecommerce.domain.entity;

import com.metro.homework.ecommerce.domain.entity.enums.OrderStatus;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Order extends BaseEntity {
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    private float subtotal;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private OrderStatus orderStatus;

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
