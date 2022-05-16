package com.example.flowdemo.controller;

import com.example.flowdemo.payload.requests.AuthRequest;
import com.example.flowdemo.services.AuthService;
import com.example.flowdemo.services.CustomUserDetailsService;
import com.example.flowdemo.services.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;
//    @Autowired
//    private AuthService authService;

    @PostMapping("/login")
    public String createToken(@RequestBody AuthRequest authRequest) throws Exception {

        try {
            authenticationManager.
                    authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    authRequest.getUsername(),
                                    authRequest.getPassword()
                            )
                    );
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);

        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

        return jwtUtil.generateToken(userDetails);
    }

//    @GetMapping("/createUsers")
//    public ResponseEntity<?> createUser() throws Exception{
//        return ResponseEntity.ok(
//                authService.createAll()
//        );
//    }

}
