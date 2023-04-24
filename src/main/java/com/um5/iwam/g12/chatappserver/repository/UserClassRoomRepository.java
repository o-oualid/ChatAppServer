package com.um5.iwam.g12.chatappserver.repository;

import com.um5.iwam.g12.chatappserver.model.UserClassroom;
import com.um5.iwam.g12.chatappserver.model.UserClassroomKey;
import com.um5.iwam.g12.chatappserver.model.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserClassRoomRepository extends CrudRepository<UserClassroom, UserClassroomKey> {

    Optional<UserClassroom> findByIdAndRole(UserClassroomKey userClassroomKey, UserRole role);
}
