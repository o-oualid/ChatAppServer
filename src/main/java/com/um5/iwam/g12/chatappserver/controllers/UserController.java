package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.dto.UserDto;
import com.um5.iwam.g12.chatappserver.model.User;
import com.um5.iwam.g12.chatappserver.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") long id) {
        return ResponseEntity.ofNullable(service.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(service.save(user));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    @PreAuthorize("@userSecurityService.is(#user.id)")
    public void update(@RequestBody User user) {
        service.save(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@userSecurityService.is(#id)")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }


}