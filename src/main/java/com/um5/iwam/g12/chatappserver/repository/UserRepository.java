package com.um5.iwam.g12.chatappserver.repository;

import com.um5.iwam.g12.chatappserver.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Iterable<User> findUsersByUserClassrooms_Classroom_Id(long classroomId);
}
