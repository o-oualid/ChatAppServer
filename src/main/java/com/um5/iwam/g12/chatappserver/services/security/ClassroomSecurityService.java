package com.um5.iwam.g12.chatappserver.services.security;

import com.um5.iwam.g12.chatappserver.model.UserClassroomKey;
import com.um5.iwam.g12.chatappserver.repository.UserClassRoomRepository;
import com.um5.iwam.g12.chatappserver.services.ClassroomService;
import com.um5.iwam.g12.chatappserver.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ClassroomSecurityService {
    private final ClassroomService classroomService;
    private final UserClassRoomRepository userClassRoomRepository;
    private final UserService userService;
    Authentication authentication;

    public ClassroomSecurityService(ClassroomService classroomService, UserClassRoomRepository userClassRoomRepository, UserService userService) {
        this.classroomService = classroomService;
        this.userClassRoomRepository = userClassRoomRepository;
        this.userService = userService;
    }


    public boolean isMember(Long id) {
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userService.findByEmail(authentication.getName());
        if (user.isEmpty()) return false;
        var classroom = userClassRoomRepository.findById(new UserClassroomKey(user.get().getId(), id));
        return classroom.isPresent();
    }

    public boolean isTeacher(Long id) {
        return false;
    }
}
