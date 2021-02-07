package com.metro.homework.ecommerce.domain.entity;

import javax.persistence.*;

@Entity
public class OrderItem extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Order order;

    private int quantity;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
