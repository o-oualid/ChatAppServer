package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.dto.PostDto;
import com.um5.iwam.g12.chatappserver.model.Post;
import com.um5.iwam.g12.chatappserver.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    private final UserService userService;


    public PostService(PostRepository postRepository, ModelMapper modelMapper, UserService userService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    public PostDto find(long id) {
        return postRepository.findById(id).map(post -> modelMapper.map(post, PostDto.class)).orElse(null);
    }

    public PostDto create(Principal principal, PostDto post) {
        var user = userService.findByEmail(principal.getName());
        if (user.isPresent())
            return modelMapper.map(postRepository.save(modelMapper.map(post, Post.class)), PostDto.class);
        else return null;
    }

    public void delete(long id) {
        postRepository.deleteById(id);
    }

    public PostDto update(PostDto post) {
        return modelMapper.map(postRepository.save(modelMapper.map(post, Post.class)), PostDto.class);
    }

}
