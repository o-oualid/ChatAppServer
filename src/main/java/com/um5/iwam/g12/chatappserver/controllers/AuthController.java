package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.dto.AuthDto;
import com.um5.iwam.g12.chatappserver.dto.AuthenticationRequest;
import com.um5.iwam.g12.chatappserver.dto.UserCreationDto;
import com.um5.iwam.g12.chatappserver.dto.UserDto;
import com.um5.iwam.g12.chatappserver.services.TokenService;
import com.um5.iwam.g12.chatappserver.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AuthController {


    private final TokenService tokenService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService, UserService userService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDto> token(@RequestBody AuthenticationRequest userLogin) {
        var user = new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password());

        try {
            Authentication authentication = authenticationManager.authenticate(user);
            return ResponseEntity.ok(new AuthDto(tokenService.generateToken(authentication)));
        } catch (AuthenticationException e) {
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> create(@Validated @RequestBody UserCreationDto user) {
        return ResponseEntity.ok(userService.create(user));
    }

}
