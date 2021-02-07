package com.metro.homework.ecommerce.service.impl;

import com.metro.homework.ecommerce.domain.entity.Article;
import com.metro.homework.ecommerce.repository.ArticleRepository;
import com.metro.homework.ecommerce.service.ArticleStockManagementService;
import com.metro.homework.ecommerce.service.exception.InvalidStockException;
import org.springframework.stereotype.Service;

import static com.metro.homework.ecommerce.service.exception.ExceptionUtils.getObjectNotFoundExceptionSupplier;

@Service
public class ArticleStockManagementServiceImpl implements ArticleStockManagementService {
    private final ArticleRepository articleRepository;

    public ArticleStockManagementServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void increaseArticleStock(Long articleId, int units) {
        Article article = getArticle(articleId);

        article.setAvailableStock(article.getAvailableStock() + units);
        articleRepository.save(article);
    }


    @Override
    public void decreaseArticleStock(Long articleId, int units) throws InvalidStockException {
        Article article = getArticle(articleId);

        if (article.getAvailableStock() < units) {
            throw new InvalidStockException("There's not enough quantity for transaction");
        }

        article.setAvailableStock(article.getAvailableStock() - units);
        articleRepository.save(article);
    }

    private Article getArticle(Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(getObjectNotFoundExceptionSupplier(articleId, "Could not find article with id: "));
    }
}
