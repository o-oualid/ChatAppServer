package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.dto.ClassroomDto;
import com.um5.iwam.g12.chatappserver.dto.InviteDto;
import com.um5.iwam.g12.chatappserver.services.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomService service;

    public ClassroomController(ClassroomService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @PreAuthorize("@classroomSecurityService.isMember(#id)")
    public ResponseEntity<ClassroomDto> findById(@PathVariable long id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_TEACHER')")
    public ResponseEntity<ClassroomDto> create(Principal principal, @RequestBody ClassroomDto classroom) {
        return ResponseEntity.ok(service.create(classroom, principal.getName()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("@classroomSecurityService.hasRole(#id,'TEACHER')")
    public ResponseEntity<ClassroomDto> update(@RequestBody ClassroomDto classroom, @PathVariable long id) {
        return ResponseEntity.ok(service.update(classroom));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@classroomSecurityService.hasRole(#id,'TEACHER')")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/invite")
    @PreAuthorize("@classroomSecurityService.hasRole(#invite.classroomId,'TEACHER')")
    public ResponseEntity<Void> invite(@RequestBody InviteDto invite) {
        service.inviteUser(invite.getUserEmail(), invite.getClassroomId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/join/{id}")
    @PreAuthorize("@classroomSecurityService.hasRole(#id, 'invited')")
    public ResponseEntity<Void> join(Principal principal, @PathVariable long id) {
        service.join(principal.getName(), id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<ClassroomDto>> findByUser(Principal principal) {
        return ResponseEntity.ok(service.findByUser(principal.getName()));
    }
}
