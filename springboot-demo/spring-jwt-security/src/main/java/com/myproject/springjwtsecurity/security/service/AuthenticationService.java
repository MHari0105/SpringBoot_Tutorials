package com.myproject.springjwtsecurity.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.springjwtsecurity.security.auth.AuthenticationResponse;
import com.myproject.springjwtsecurity.security.auth.LoginRequest;
import com.myproject.springjwtsecurity.security.auth.RegisterRequest;
import com.myproject.springjwtsecurity.security.model.Role;
import com.myproject.springjwtsecurity.security.model.User;
import com.myproject.springjwtsecurity.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .mailId(request.getMailId())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.PUBLIC)
                    .build();
        
        userRepo.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(LoginRequest request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getMailId(), request.getPassword())
        );

        var user = userRepo.findByMailId(request.getMailId()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    
}
