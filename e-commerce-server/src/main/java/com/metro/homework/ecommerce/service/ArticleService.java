package com.metro.homework.ecommerce.service;

import com.metro.homework.ecommerce.domain.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getArticles();

    void saveArticle(Article article);
}
