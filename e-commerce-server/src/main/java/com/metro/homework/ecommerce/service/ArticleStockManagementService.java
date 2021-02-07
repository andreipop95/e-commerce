package com.metro.homework.ecommerce.service;

import com.metro.homework.ecommerce.service.exception.InvalidStockException;
import com.metro.homework.ecommerce.service.exception.ObjectNotFoundException;

public interface ArticleStockManagementService {
    void increaseArticleStock(Long articleId, int units);

    void decreaseArticleStock(Long articleId, int units) throws InvalidStockException;
}
