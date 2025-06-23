package com.app.gym.controller;

import com.app.gym.model.dto.*;
import com.app.gym.model.User;
import com.app.gym.model.RefreshToken;
import com.app.gym.service.AuthService;
import com.app.gym.service.RefreshTokenService;
import com.app.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, RefreshTokenService refreshTokenService, UserService userService) {
        this.authService = authService;
        this.refreshTokenService = refreshTokenService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        String jwt = authService.login(request.getUsername(), request.getPassword());
        User user = userService.findByUsername(request.getUsername()).orElseThrow(
            () -> new RuntimeException("User not found")
        );
        RefreshToken refreshToken = refreshTokenService.createToken(user);
        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), "Bearer"));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupRequest request) {
        User user = authService.signup(request.getUsername(), request.getPassword(), request.getRole());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(@RequestBody TokenRefreshRequest request) {
        String jwt = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(new JwtResponse(jwt, request.getRefreshToken()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody TokenRefreshRequest request) {
        authService.logout(request.getRefreshToken());
        return ResponseEntity.ok().build();
    }
} 