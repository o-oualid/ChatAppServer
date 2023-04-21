package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.model.User;
import com.um5.iwam.g12.chatappserver.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<User> findByEmail(String x) {
        return repository.findByEmail(x);
    }

    public Optional<User> findById(long id) {
        return repository.findById(id);
    }

    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
