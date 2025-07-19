package com.platform.vaultbase_app.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.platform.vaultbase_app.entity.AuthProvider;
import com.platform.vaultbase_app.entity.Role;
import com.platform.vaultbase_app.entity.User;
import com.platform.vaultbase_app.repository.UserRepository;
import com.platform.vaultbase_app.security.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GoogleAuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Value("${google.clientId}")
    private String googleClientId;

    public GoogleAuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String verifyGoogleToken(String idTokenString) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                    new NetHttpTransport(),
                    GsonFactory.getDefaultInstance()
            )
                    .setAudience(Collections.singletonList(googleClientId))
                    .build();

            GoogleIdToken idToken = verifier.verify(idTokenString);

            if (idToken == null) throw new IllegalArgumentException("Invalid ID token");

            GoogleIdToken.Payload payload = idToken.getPayload();
            String email = payload.getEmail();

            User user = userRepository.findByEmail(email).orElseGet(() -> {
                User newUser = new User();
                newUser.setEmail(email);
                newUser.setProvider(AuthProvider.GOOGLE);
                newUser.setRole(Role.ROLE_USER);
                return userRepository.save(newUser);
            });

            return jwtUtil.generateToken(user);

        } catch (Exception e) {
            throw new RuntimeException("Google authentication failed", e);
        }
    }
}
