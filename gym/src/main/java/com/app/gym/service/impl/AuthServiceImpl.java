package com.app.gym.service.impl;

import com.app.gym.model.User;
import com.app.gym.model.RefreshToken;
import com.app.gym.repository.UserRepository;
import com.app.gym.security.JwtUtil;
import com.app.gym.service.AuthService;
import com.app.gym.service.UserService;
import com.app.gym.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final RefreshTokenService refreshTokenService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthServiceImpl(UserService userService,
                           RefreshTokenService refreshTokenService,
                           JwtUtil jwtUtil,
                           UserRepository userRepository) {
        this.userService = userService;
        this.refreshTokenService = refreshTokenService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Override
    public String login(String username, String password) {
        Optional<User> userOpt = userService.findByUsername(username);
        if (userOpt.isEmpty() || !passwordEncoder.matches(password, userOpt.get().getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        User user = userOpt.get();
        // Generate JWT
        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }

    @Override
    public User signup(String username, String password, String role) {
        if (userService.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }
        return userService.createUser(username, password, role);
    }

    @Override
    public String refresh(String refreshTokenStr) {
        RefreshToken refreshToken = refreshTokenService.findByToken(refreshTokenStr)
                .map(refreshTokenService::verifyExpiration)
                .orElseThrow(() -> new RuntimeException("Invalid refresh token"));
        User user = refreshToken.getUser();
        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }

    @Override
    public void logout(String refreshTokenStr) {
        refreshTokenService.findByToken(refreshTokenStr).ifPresent(refreshTokenService::revokeToken);
    }
} 