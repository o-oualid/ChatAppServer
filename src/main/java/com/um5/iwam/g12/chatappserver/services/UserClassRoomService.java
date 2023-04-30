package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.model.*;
import com.um5.iwam.g12.chatappserver.repository.UserClassRoomRepository;
import com.um5.iwam.g12.chatappserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserClassRoomService {
    private final UserClassRoomRepository userClassRoomRepository;
    private final UserRepository userRepository;

    public UserClassRoomService(UserClassRoomRepository userClassRoomRepository, UserRepository userRepository) {
        this.userClassRoomRepository = userClassRoomRepository;
        this.userRepository = userRepository;
    }

    public void AddUser(Classroom classroom, String userEmail, UserRole role, Status status) {
        userRepository.findByEmail(userEmail).ifPresent(user -> AddUser(classroom, user, role, status));
    }

    public void AddUser(Classroom classRoom, User user, UserRole role, Status status) {
        userClassRoomRepository.save(new UserClassroom(classRoom, user, role, status));
    }

    public boolean isMemberOfClassroom(Long classRoomId, Long id) {
        return userClassRoomRepository.findById(new UserClassroomKey(id, classRoomId)).isPresent();
    }


    public boolean hasRole(Long classRoomId, Long id, UserRole role) {
        return userClassRoomRepository.findByIdAndRole(new UserClassroomKey(id, classRoomId), role).isPresent();
    }

    public void joinClassroom(String email, long classroomId) {
        userRepository.findByEmail(email).ifPresent(user -> joinClassroom(user, classroomId));
    }

    private void joinClassroom(User user, long classroomId) {
        userClassRoomRepository.findByIdAndStatus(new UserClassroomKey(user.getId(), classroomId), Status.INVITED).ifPresent(userClassroom -> {
            userClassroom.setStatus(Status.ACTIVE);
            userClassRoomRepository.save(userClassroom);
        });
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean hasStatus(Long classRoomId, Long id, Status status) {
        return userClassRoomRepository.findByIdAndStatus(new UserClassroomKey(id, classRoomId), status).isPresent();
    }
}
