package com.platform.vaultbase_app.controller;

import com.platform.vaultbase_app.entity.User;
import com.platform.vaultbase_app.service.AuthService;
import com.platform.vaultbase_app.service.GoogleAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private GoogleAuthService googleAuthService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body){
        User user = authService.register(body.get("email"), body.get("password"));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body){
        String token = authService.login(body.get("email"), body.get("password"));
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    @PostMapping("/oauth/google")
    public ResponseEntity<?> googleAuth(@RequestBody Map<String, String> body) {
        String idToken = body.get("token");
        String jwt = googleAuthService.verifyGoogleToken(idToken);
        return ResponseEntity.ok(Map.of("token", jwt));
    }
}
