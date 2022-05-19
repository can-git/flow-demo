package com.example.flowdemo.controller;

import com.example.flowdemo.config.JwtTokenProvider;
import com.example.flowdemo.models.Account;
import com.example.flowdemo.payload.requests.Auth.LoginRequest;
import com.example.flowdemo.payload.requests.Auth.SignUpRequest;
import com.example.flowdemo.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@Valid @RequestBody LoginRequest loginRequest)
            throws Exception {

        Authentication authentication;
        try {
             authentication = authenticationManager.
                    authenticate(loginRequest.get());

        }
        catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        String jwt = jwtTokenProvider.createToken(authentication.getName(), authentication.getAuthorities());

        Map<String, Object> responseBody = Map.of(
                "idToken" , jwt,
                "tokenType", "Bearer",
                "roles", authentication.getAuthorities()
        );

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                .body(responseBody);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest request) {
        Account account = authService.create(request);
        account.setPassword("?secret?");
        return ResponseEntity.ok(account);
    }
}
