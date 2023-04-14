package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.model.Classroom;
import com.um5.iwam.g12.chatappserver.repository.ClassroomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomRepository repository;

    public ClassroomController(ClassroomRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> findById(@PathVariable("id") Classroom classroom) {
        return ResponseEntity.ok(classroom);
    }

    @PostMapping
    public ResponseEntity<Classroom> create(@RequestBody Classroom classroom) {
        return ResponseEntity.ok(repository.save(classroom));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> update(@RequestBody Classroom classroom, @PathVariable long id) {
        return ResponseEntity.ok(repository.save(classroom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
