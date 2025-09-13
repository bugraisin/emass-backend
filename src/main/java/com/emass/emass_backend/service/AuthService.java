package com.emass.emass_backend.service;

import com.emass.emass_backend.model.dto.auth.AuthResponse;
import com.emass.emass_backend.model.dto.auth.LoginRequest;
import com.emass.emass_backend.model.dto.auth.RegisterRequest;
import com.emass.emass_backend.model.entity.User;
import com.emass.emass_backend.model.entity.enums.Role;
import com.emass.emass_backend.repository.user.UserRepository;
import com.emass.emass_backend.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest req) {
        if (repo.existsByEmail(req.email())) {
            throw new IllegalStateException("Email kullanımda");
        }
        var user = User.builder()
                .email(req.email())
                .password(encoder.encode(req.password()))
                .username(req.username())
                .role(Role.USER)
                .build();

        var savedUser = repo.save(user);
        String token = jwtUtil.generateToken(savedUser);

        AuthResponse.UserInfo userInfo = new AuthResponse.UserInfo(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getUsername()
        );

        return new AuthResponse(token, userInfo);
    }

    public AuthResponse login(LoginRequest req) {
        var user = repo.findByEmail(req.email())
                .orElseThrow(() -> new IllegalArgumentException("Kullanıcı bulunamadı"));

        if (!encoder.matches(req.password(), user.getPassword())) {
            throw new IllegalArgumentException("Hatalı şifre");
        }

        String token = jwtUtil.generateToken(user);

        AuthResponse.UserInfo userInfo = new AuthResponse.UserInfo(
                user.getId(),
                user.getEmail(),
                user.getUsername()
        );

        return new AuthResponse(token, userInfo);
    }
}