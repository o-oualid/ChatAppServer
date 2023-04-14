package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.model.Assignment;

import com.um5.iwam.g12.chatappserver.repository.AssignmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentRepository repository;

    public AssignmentController(AssignmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> findById(@PathVariable("id") Assignment assignment) {
        return ResponseEntity.ok(assignment);
    }

    @PostMapping
    public ResponseEntity<Assignment> create(@RequestBody Assignment assignment) {
        return ResponseEntity.ok(repository.save(assignment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> update(@RequestBody Assignment assignment, @PathVariable long id) {
        return ResponseEntity.ok(repository.save(assignment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
