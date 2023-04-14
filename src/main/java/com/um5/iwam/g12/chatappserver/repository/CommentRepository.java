package com.um5.iwam.g12.chatappserver.repository;

import com.um5.iwam.g12.chatappserver.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
