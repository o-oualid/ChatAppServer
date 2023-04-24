package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.dto.ClassDto;
import com.um5.iwam.g12.chatappserver.dto.InviteDto;
import com.um5.iwam.g12.chatappserver.services.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomService service;

    public ClassroomController(ClassroomService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @PreAuthorize("@classroomSecurityService.isMember(#id)")
    public ResponseEntity<ClassDto> findById(@PathVariable long id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_TEACHER')")
    public ResponseEntity<ClassDto> create(Principal principal, @RequestBody ClassDto classroom) {
        return ResponseEntity.ok(service.create(classroom, principal.getName()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_TEACHER')")
    public ResponseEntity<ClassDto> update(@RequestBody ClassDto classroom, @PathVariable long id) {
        return ResponseEntity.ok(service.update(classroom));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_TEACHER')")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/invite/{classroomId}")
    @PreAuthorize("@classroomSecurityService.isTeacher(#invite.classroomId)")
    public ResponseEntity<Void> invite(@RequestBody InviteDto invite) {
        service.inviteUser(invite.getUserEmail(), invite.getClassroomId());
        return ResponseEntity.noContent().build();
    }
}
