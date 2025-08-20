package com.emass.emass_backend.service;

import com.emass.emass_backend.model.dto.auth.LoginRequest;
import com.emass.emass_backend.model.dto.auth.RegisterRequest;
import com.emass.emass_backend.model.entity.User;
import com.emass.emass_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public void register(RegisterRequest req) {
        if (repo.existsByEmail(req.email())) {
            throw new IllegalStateException("Email already in use");
        }
        var user = User.builder()
                .email(req.email())
                .password(encoder.encode(req.password()))
                .name(req.name())
                .build();
        repo.save(user);
    }

    public User login(LoginRequest req) {
        var user = repo.findByEmail(req.email())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!encoder.matches(req.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return user; // başarılı → user objesi döndür
    }
}
