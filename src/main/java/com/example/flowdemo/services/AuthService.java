package com.example.flowdemo.services;


import com.example.flowdemo.Repository.AccountRepository;
import com.example.flowdemo.models.Account;
import com.example.flowdemo.payload.requests.Auth.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    public boolean getUserByUsername(String username){
        return accountRepository.existsByUsername(username);
    }

    public Account create(SignUpRequest request) {
        if (accountRepository.existsByUsername(request.getUsername()))
            throw new BadCredentialsException("Username already exists");
        return accountRepository.insert(
                Account.builder()
                        .creationDate(System.currentTimeMillis())
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .roles(List.of("ROLE_USER"))
                        .disabled(false)
                        .build()
        );
    }
}
