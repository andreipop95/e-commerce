package com.metro.homework.ecommerce.repository;

import com.metro.homework.ecommerce.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
