package com.um5.iwam.g12.chatappserver.services.security;

import com.um5.iwam.g12.chatappserver.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService {

    private final UserService userService;
    Authentication authentication;


    public UserSecurityService(UserService userService) {
        this.userService = userService;
    }

    public boolean is(Long id) {
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userService.findByEmail(authentication.getName());
        authentication.getPrincipal();
        return user.map(value -> value.getId().equals(id)).orElse(false);
    }
}
