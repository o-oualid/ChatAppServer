package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.dto.UserCreationDto;
import com.um5.iwam.g12.chatappserver.dto.UserDto;
import com.um5.iwam.g12.chatappserver.model.User;
import com.um5.iwam.g12.chatappserver.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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
        return repository.findById(id).map(value -> modelMapper.map(value, UserDto.class)).orElse(null);

    }

    public UserDto create(UserCreationDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        var userModel = modelMapper.map(user, User.class);
        return modelMapper.map(repository.save(userModel), UserDto.class);

    }

    public void update(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<UserDto> findAllByClassroom(long classroomId) {
        return StreamSupport.stream(repository.findUsersByUserClassrooms_Classroom_Id(classroomId).spliterator(), false)
                .map(user -> modelMapper.map(user, UserDto.class)).toList();
    }
}
