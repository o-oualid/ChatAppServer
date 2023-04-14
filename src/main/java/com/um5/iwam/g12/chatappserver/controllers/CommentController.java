package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.model.Comment;
import com.um5.iwam.g12.chatappserver.repository.CommentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository repository;

    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable("id") Comment comment) {
        return ResponseEntity.ok(comment);
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        return ResponseEntity.ok(repository.save(comment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment, @PathVariable long id) {
        return ResponseEntity.ok(repository.save(comment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
