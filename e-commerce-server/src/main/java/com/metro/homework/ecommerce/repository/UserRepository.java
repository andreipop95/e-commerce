package com.metro.homework.ecommerce.repository;

import com.metro.homework.ecommerce.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
