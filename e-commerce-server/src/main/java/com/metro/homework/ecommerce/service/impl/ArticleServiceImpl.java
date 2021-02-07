package com.metro.homework.ecommerce.service.impl;

import com.metro.homework.ecommerce.domain.entity.Article;
import com.metro.homework.ecommerce.repository.ArticleRepository;
import com.metro.homework.ecommerce.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> getArticles() {
        return this.articleRepository.findAll();
    }

    @Override
    public void saveArticle(Article article) {
        this.articleRepository.save(article);
    }
}
