package com.app.gym.service;

import com.app.gym.model.User;
import com.app.gym.model.RefreshToken;

public interface AuthService {
    String login(String username, String password);
    User signup(String username, String password, String role);
    String refresh(String refreshToken);
    void logout(String refreshToken);
} 