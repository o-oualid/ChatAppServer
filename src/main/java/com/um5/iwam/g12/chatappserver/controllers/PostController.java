package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.model.Post;
import com.um5.iwam.g12.chatappserver.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    ResponseEntity<Post> getPostById(@PathVariable long id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Post> create(@Valid @RequestBody Post post) {
        return ResponseEntity.ok(repository.save(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@RequestBody Post post, @PathVariable long id) {
        return ResponseEntity.ok(repository.save(post));
    }

}
