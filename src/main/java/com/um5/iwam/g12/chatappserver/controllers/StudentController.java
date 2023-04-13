package com.um5.iwam.g12.chatappserver.controllers;

import com.um5.iwam.g12.chatappserver.model.Student;
import com.um5.iwam.g12.chatappserver.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> getAll() {
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable String id) {
        return repository.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student create(@Valid @RequestBody Student student) {
        return repository.create(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Student student, @PathVariable String id) {

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

}