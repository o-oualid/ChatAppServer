package com.um5.iwam.g12.chatappserver.repository;

import com.um5.iwam.g12.chatappserver.model.UserClassroom;
import com.um5.iwam.g12.chatappserver.model.UserClassroomKey;
import org.springframework.data.repository.CrudRepository;

public interface UserClassRoomRepository extends CrudRepository<UserClassroom, UserClassroomKey> {

}
