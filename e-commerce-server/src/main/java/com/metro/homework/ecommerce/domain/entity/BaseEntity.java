package com.metro.homework.ecommerce.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = -1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
