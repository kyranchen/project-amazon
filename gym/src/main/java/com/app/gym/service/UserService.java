package com.app.gym.service;

import com.app.gym.model.User;
import java.util.Optional;

public interface UserService {
    User createUser(String username, String password, String role);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
} 