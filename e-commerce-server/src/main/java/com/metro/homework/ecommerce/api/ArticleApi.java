package com.metro.homework.ecommerce.api;

import com.metro.homework.ecommerce.api.dto.ArticleDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("article")
public interface ArticleApi {

    @GetMapping()
    List<ArticleDTO> getArticles();

    @PostMapping("/create")
    void createArticle(@RequestBody ArticleDTO articleDTO);
}
