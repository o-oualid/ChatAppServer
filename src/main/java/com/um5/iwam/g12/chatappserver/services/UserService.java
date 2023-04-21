package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.dto.UserDto;
import com.um5.iwam.g12.chatappserver.model.User;
import com.um5.iwam.g12.chatappserver.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;


    public UserService(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    public Optional<User> findByEmail(String x) {
        return repository.findByEmail(x);
    }

    public UserDto findById(long id) {
        var user = repository.findById(id);
        return user.map(value -> modelMapper.map(value, UserDto.class)).orElse(null);

    }

    public UserDto save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return modelMapper.map(repository.save(user), UserDto.class);

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}