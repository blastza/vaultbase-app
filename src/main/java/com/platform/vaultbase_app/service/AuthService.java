package com.platform.vaultbase_app.service;

import com.platform.vaultbase_app.entity.AuthProvider;
import com.platform.vaultbase_app.entity.Role;
import com.platform.vaultbase_app.entity.User;
import com.platform.vaultbase_app.repository.UserRepository;
import com.platform.vaultbase_app.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public User register(String email, String password){
        String hashedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRole(Role.ROLE_USER);
        user.setProvider(AuthProvider.LOCAL);

        return userRepository.save(user);
    }

    public String login(String email, String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new RuntimeException("Invalid password");
        return jwtUtil.generateToken(user);
    }
}
