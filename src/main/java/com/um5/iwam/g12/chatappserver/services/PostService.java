package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.dto.PostDto;
import com.um5.iwam.g12.chatappserver.model.Post;
import com.um5.iwam.g12.chatappserver.repository.ClassroomRepository;
import com.um5.iwam.g12.chatappserver.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    private final ClassroomRepository classroomService;
    private final UserService userService;


    public PostService(PostRepository postRepository, ModelMapper modelMapper, ClassroomRepository classroomRepository, UserService userService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.classroomService = classroomRepository;
        this.userService = userService;
    }

    public PostDto find(long id) {
        return postRepository.findById(id).map(post -> modelMapper.map(post, PostDto.class)).orElse(null);
    }

    public PostDto create(Principal principal, PostDto post) {
        var user = userService.findByEmail(principal.getName());
        if (user.isEmpty()) return null;
        var classroom = classroomService.findById(post.getClassroom_id());
        if (classroom.isEmpty()) return null;
        return modelMapper.map(postRepository.save(new Post(user.get(), classroom.get(), new ArrayList<>(), post.getContent())), PostDto.class);
    }

    public void delete(long id) {
        postRepository.deleteById(id);
    }

    public PostDto update(PostDto post) {
        return modelMapper.map(postRepository.save(modelMapper.map(post, Post.class)), PostDto.class);
    }

    public List<PostDto> findByClassroom(long id) {
        return StreamSupport.stream(postRepository.findPostsByClassroom_Id(id).spliterator(), false).map(post -> modelMapper.map(post, PostDto.class)).toList();
    }
}
