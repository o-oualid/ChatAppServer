package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.model.User;
import com.um5.iwam.g12.chatappserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    final
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findByEmail(String x) {
        return repository.findByEmail(x);
    }
}
