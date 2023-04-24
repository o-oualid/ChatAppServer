package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.dto.UserDto;
import com.um5.iwam.g12.chatappserver.model.User;
import com.um5.iwam.g12.chatappserver.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    @PreAuthorize("@userSecurityService.is(#user.id)")
    public void update(@RequestBody User user) {
        service.update(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@userSecurityService.is(#id)")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/classroom/{id}")
    public ResponseEntity<List<UserDto>> findByClassroom(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.findAllByClassroom(id));
    }

}