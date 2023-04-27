package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.dto.PostDto;
import com.um5.iwam.g12.chatappserver.model.Post;
import com.um5.iwam.g12.chatappserver.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public PostDto find(long id) {
        return postRepository.findById(id).map(post -> modelMapper.map(post, PostDto.class)).orElse(null);
    }

    public PostDto create(PostDto post) {
        return modelMapper.map(postRepository.save(modelMapper.map(post, Post.class)), PostDto.class);
    }

    public void delete(long id) {
        postRepository.deleteById(id);
    }

    public PostDto update(PostDto post) {
        return modelMapper.map(postRepository.save(modelMapper.map(post, Post.class)), PostDto.class);
    }

}
