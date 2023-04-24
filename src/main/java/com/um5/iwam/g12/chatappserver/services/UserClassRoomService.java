package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.model.*;
import com.um5.iwam.g12.chatappserver.repository.UserClassRoomRepository;
import com.um5.iwam.g12.chatappserver.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public boolean isTeacherOfClassroom(Long classRoomId, Long id) {
        return userClassRoomRepository.findByIdAndRole(new UserClassroomKey(id, classRoomId), UserRole.TEACHER).isPresent();
    }
}
