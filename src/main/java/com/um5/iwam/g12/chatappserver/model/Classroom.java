package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue
    long id;

    @NotBlank
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    User teacher;

    @ManyToMany(fetch = FetchType.LAZY)
    List<User> students;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classRoom")
    List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classRoom")
    List<Assignment> assignments;

    public Classroom() {
    }

    public Classroom(String name, User teacher, List<User> students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
