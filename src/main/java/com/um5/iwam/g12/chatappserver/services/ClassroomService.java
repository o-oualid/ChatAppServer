package com.um5.iwam.g12.chatappserver.services;


import com.um5.iwam.g12.chatappserver.dto.ClassDto;
import com.um5.iwam.g12.chatappserver.model.Classroom;
import com.um5.iwam.g12.chatappserver.model.UserRole;
import com.um5.iwam.g12.chatappserver.repository.ClassroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomService {
    private final UserClassRoomService userClassRoomService;
    private final ClassroomRepository repository;
    private final ModelMapper modelMapper;


    public ClassroomService(UserClassRoomService userClassRoomService, ClassroomRepository repository, ModelMapper modelMapper) {
        this.userClassRoomService = userClassRoomService;
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    public ClassDto create(ClassDto classroom, String ownerEmail) {
        Classroom classroomRepo = repository.save(modelMapper.map(classroom, Classroom.class));
        userClassRoomService.AddUser(classroomRepo, ownerEmail, UserRole.TEACHER);
        return modelMapper.map(classroomRepo, ClassDto.class);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public ClassDto update(ClassDto classroom) {
        return modelMapper.map(repository.save((modelMapper.map(classroom, Classroom.class))), ClassDto.class);
    }

    public Optional<ClassDto> findById(long id) {
        return Optional.ofNullable(modelMapper.map(repository.findById(id), ClassDto.class));
    }


}
