package com.metro.homework.ecommerce.service.impl;

import com.metro.homework.ecommerce.domain.entity.User;
import com.metro.homework.ecommerce.repository.UserRepository;
import com.metro.homework.ecommerce.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    private User authenticatedUser;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    void fetchCurrentUserOrCreateIt() {
        List<User> fetchedUsers = userRepository.findAll();
        if (fetchedUsers.isEmpty()) {
            this.authenticatedUser = userRepository.save(getMockUser());
        } else {
            this.authenticatedUser = fetchedUsers.get(0);
        }
    }

    @Override
    public User getAuthenticatedUser() {
        logger.debug("Fetching the authenticated user");
        return authenticatedUser;
    }

    private User getMockUser() {
        User mockUser = new User();
        mockUser.setName("Max Musterman");
        mockUser.setEmail("max.musterman@mail.com");
        mockUser.setUsername("max");
        return mockUser;
    }
}
