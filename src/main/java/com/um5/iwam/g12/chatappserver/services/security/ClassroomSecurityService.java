package com.um5.iwam.g12.chatappserver.services.security;

import com.um5.iwam.g12.chatappserver.model.UserRole;
import com.um5.iwam.g12.chatappserver.services.UserClassRoomService;
import com.um5.iwam.g12.chatappserver.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ClassroomSecurityService {
    private final UserClassRoomService userClassRoomService;
    private final UserService userService;
    Authentication authentication;

    public ClassroomSecurityService(UserClassRoomService userClassRoomService, UserService userService) {
        this.userClassRoomService = userClassRoomService;
        this.userService = userService;
    }


    public boolean isMember(Long classRoomId) {
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userService.findByEmail(authentication.getName());
        if (user.isEmpty()) return false;
        return userClassRoomService.isMemberOfClassroom(classRoomId, user.get().getId());
    }

    public boolean hasRole(Long classRoomId, UserRole role) {
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userService.findByEmail(authentication.getName());
        if (user.isEmpty()) return false;
        return userClassRoomService.hasRole(classRoomId, user.get().getId(), role);
    }

}
