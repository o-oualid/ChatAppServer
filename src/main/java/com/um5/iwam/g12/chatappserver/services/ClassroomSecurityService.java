package com.um5.iwam.g12.chatappserver.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ClassroomSecurityService {
    final
    ClassroomService service;
    Authentication authentication;

    public ClassroomSecurityService(ClassroomService service) {
        this.service = service;
    }

    public boolean isMember(Long id) {
        //  this.authentication = SecurityContextHolder.getContext().getAuthentication();
        //SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        return false;
    }

    public boolean isTeacher(Long id) {
        return false;
    }
}
