package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.dto.LoginRequest;
import com.emass.emass_backend.model.dto.RegisterRequest;
import com.emass.emass_backend.model.entity.User;
import com.emass.emass_backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        try {
            service.register(req);
            return ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
        try {
            User u = service.login(req);
            // Şimdilik basit response
            return ResponseEntity.ok(new LoginResponse(u.getId(), u.getEmail(), u.getName()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    // DTO: Login cevabı
    public record LoginResponse(Long id, String email, String name) {}
}
