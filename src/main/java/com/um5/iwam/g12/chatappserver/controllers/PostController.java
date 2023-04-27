package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.dto.PostDto;
import com.um5.iwam.g12.chatappserver.services.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<PostDto> getPostById(@PathVariable long id) {
        return ResponseEntity.ofNullable(service.find(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<PostDto> create(@Valid @RequestBody PostDto post) {
        return ResponseEntity.ok(service.create(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> update(@RequestBody PostDto post, @PathVariable long id) {
        return ResponseEntity.ok(service.update(post));
    }

}
