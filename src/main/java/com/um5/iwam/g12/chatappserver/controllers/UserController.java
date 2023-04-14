package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.model.User;
import com.um5.iwam.g12.chatappserver.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<User> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") User user) {
        return user;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return repository.save(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Long id) {
    }

   @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}