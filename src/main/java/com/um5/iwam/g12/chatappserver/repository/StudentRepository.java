package com.um5.iwam.g12.chatappserver.repository;

import com.um5.iwam.g12.chatappserver.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class StudentRepository {
    ArrayList<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(
                UUID.randomUUID().toString()
                , "oualid", "ouazrou"));
    }

    public ArrayList<Student> getAll() {
        return students;
    }

    public Student getById(String id) {
        return students.stream().filter(student -> student.id().equals(id)).findFirst().orElse(null);
    }

    public Student create(Student student) {
        students.add(student);
        return student;
    }

    public void delete(String id) {
        students.removeIf(student -> student.id().equals(id));
    }

    public void updateStudent(Student student, String id) {
        Student existing = students.stream().filter(s -> s.id().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Student not found"));
        int index = students.indexOf(existing);
        students.set(index, student);
    }
}
