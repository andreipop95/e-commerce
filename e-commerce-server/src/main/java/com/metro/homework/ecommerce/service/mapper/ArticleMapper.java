package com.metro.homework.ecommerce.service.mapper;

import com.metro.homework.ecommerce.api.dto.ArticleDTO;
import com.metro.homework.ecommerce.domain.entity.Article;
import org.springframework.stereotype.Service;

@Service
public class ArticleMapper {

    public ArticleDTO toDTO(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setName(article.getName());
        articleDTO.setDescription(article.getDescription());
        articleDTO.setPrice(article.getPrice());
        articleDTO.setAvailableStock(article.getAvailableStock());
        return articleDTO;
    }

    public Article fromDTO(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setName(articleDTO.getName());
        article.setDescription(articleDTO.getDescription());
        article.setPrice(articleDTO.getPrice());
        article.setAvailableStock(articleDTO.getAvailableStock());
        return article;
    }
}
