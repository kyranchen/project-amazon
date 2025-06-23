package com.app.gym.service;

import com.app.gym.model.RefreshToken;
import com.app.gym.model.User;
import java.util.Optional;

public interface RefreshTokenService {
    RefreshToken createToken(User user);
    Optional<RefreshToken> findByToken(String token);
    RefreshToken verifyExpiration(RefreshToken token);
    void revokeToken(RefreshToken token);
    void deleteAllByUser(User user);
} 