package com.um5.iwam.g12.chatappserver.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @PreAuthorize("hasPermission('home', 'read')")
    @GetMapping("/")
    public String home(Principal principal) {
        return "Hello ";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        return "Hello " + principal.getName();
    }

    @GetMapping("/admin")
    public String admin(Principal principal) {
        return "Hello " + principal.getName();
    }
}
