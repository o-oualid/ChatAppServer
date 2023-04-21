package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.dto.AuthenticationRequest;
import com.um5.iwam.g12.chatappserver.services.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController()
public class AuthController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public AuthController(BCryptPasswordEncoder bCryptPasswordEncoder, TokenService tokenService, AuthenticationManager authenticationManager) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/principal")
    public String principal(Principal principal) {
        return "Hello " + principal.getName() + " !";
    }

    @PostMapping("/auth")
    public String token(@RequestBody AuthenticationRequest userLogin) {
        var user = new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password());
        try {
            Authentication authentication = authenticationManager.authenticate(user);
            return tokenService.generateToken(authentication);
        } catch (AuthenticationException e) {
            return "auth error";

        }
    }
}
