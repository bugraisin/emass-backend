package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.dto.auth.AuthResponse;
import com.emass.emass_backend.model.dto.auth.LoginRequest;
import com.emass.emass_backend.model.dto.auth.RegisterRequest;
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
            AuthResponse response = service.register(req);
            return ResponseEntity.ok(new ApiResponse(
                    "Kayıt başarılı",
                    response.getToken(),
                    response.getUser()
            ));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ErrorResponse("Bir hata oluştu"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
        try {
            AuthResponse response = service.login(req);
            return ResponseEntity.ok(new ApiResponse(
                    "Giriş başarılı",
                    response.getToken(),
                    response.getUser()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ErrorResponse("Bir hata oluştu"));
        }
    }

    public record ApiResponse(String message, String token, AuthResponse.UserInfo user) {}
    public record ErrorResponse(String message) {}
}