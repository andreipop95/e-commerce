package com.metro.homework.ecommerce.domain.entity;

import javax.persistence.Entity;

@Entity
public class Article extends BaseEntity {
    private String name;
    private float price;
    private String description;
    private int availableStock;

    public String getName() {
        return name;
    }

    public void setName(String articleName) {
        this.name = articleName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int nrAvailableItems) {
        this.availableStock = nrAvailableItems;
    }
}
