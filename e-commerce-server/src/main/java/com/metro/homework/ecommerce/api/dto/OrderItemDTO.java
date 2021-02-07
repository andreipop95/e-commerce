package com.metro.homework.ecommerce.api.dto;

public class OrderItemDTO {
    private long id;
    private ArticleDTO articleDTO;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArticleDTO getArticleDTO() {
        return articleDTO;
    }

    public void setArticleDTO(ArticleDTO articleDTO) {
        this.articleDTO = articleDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
