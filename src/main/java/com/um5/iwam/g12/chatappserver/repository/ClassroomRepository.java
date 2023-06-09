package com.um5.iwam.g12.chatappserver.repository;

import com.um5.iwam.g12.chatappserver.model.Classroom;
import com.um5.iwam.g12.chatappserver.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepository extends CrudRepository<Classroom, Long> {
    Iterable<Classroom> findClassroomsByUserClassrooms_User_Id(long userId);

    Iterable<Object> findClassroomsByUserClassrooms_User_IdAndUserClassrooms_Status(Long id, Status status);
}
