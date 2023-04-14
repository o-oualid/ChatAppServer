package com.um5.iwam.g12.chatappserver.repository;

import com.um5.iwam.g12.chatappserver.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
