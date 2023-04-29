package com.um5.iwam.g12.chatappserver.services;


import com.um5.iwam.g12.chatappserver.dto.ClassroomDto;
import com.um5.iwam.g12.chatappserver.model.Classroom;
import com.um5.iwam.g12.chatappserver.model.Status;
import com.um5.iwam.g12.chatappserver.model.UserRole;
import com.um5.iwam.g12.chatappserver.repository.ClassroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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


    public ClassroomDto create(ClassroomDto classroom, String ownerEmail) {
        Classroom classroomRepo = repository.save(modelMapper.map(classroom, Classroom.class));
        userClassRoomService.AddUser(classroomRepo, ownerEmail, UserRole.TEACHER, Status.ACTIVE);
        return modelMapper.map(classroomRepo, ClassroomDto.class);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public ClassroomDto update(ClassroomDto classroom) {
        return modelMapper.map(repository.save((modelMapper.map(classroom, Classroom.class))), ClassroomDto.class);
    }

    public Optional<ClassroomDto> findById(long id) {
        return Optional.ofNullable(modelMapper.map(repository.findById(id), ClassroomDto.class));
    }


    public void inviteUser(String userEmail, long classroomId) {
        repository.findById(classroomId).ifPresent(classroom -> userClassRoomService.AddUser(classroom, userEmail, UserRole.STUDENT, Status.INVITED));
    }

    public void join(String email, long classroomId) {
        userClassRoomService.joinClassroom(email, classroomId);
    }

    public List<ClassroomDto> findByUser(String email) {
        var user = userClassRoomService.findByEmail(email);
        return user.map(value -> StreamSupport.stream(repository.findClassroomsByUserClassrooms_User_IdAndUserClassrooms_Status(value.getId(), Status.ACTIVE).spliterator(), false)
                .map(classroom -> modelMapper.map(classroom, ClassroomDto.class)).toList()).orElse(null);

    }

    public List<ClassroomDto> invites(String email) {
        var user = userClassRoomService.findByEmail(email);
        return user.map(value -> StreamSupport.stream(repository.findClassroomsByUserClassrooms_User_IdAndUserClassrooms_Status(value.getId(), Status.INVITED).spliterator(), false)
                .map(classroom -> modelMapper.map(classroom, ClassroomDto.class)).toList()).orElse(null);
    }
}
