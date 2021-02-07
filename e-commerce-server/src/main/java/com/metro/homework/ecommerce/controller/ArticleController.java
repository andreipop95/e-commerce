package com.metro.homework.ecommerce.controller;

import com.metro.homework.ecommerce.api.ArticleApi;
import com.metro.homework.ecommerce.api.dto.ArticleDTO;
import com.metro.homework.ecommerce.service.ArticleService;
import com.metro.homework.ecommerce.service.mapper.ArticleMapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArticleController implements ArticleApi {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    public ArticleController(ArticleService articleService,
                             ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @Override
    public List<ArticleDTO> getArticles() {
        return articleService.getArticles()
                .stream()
                .map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createArticle(ArticleDTO articleDTO) {
        articleService.saveArticle(articleMapper.fromDTO(articleDTO));
    }
}
