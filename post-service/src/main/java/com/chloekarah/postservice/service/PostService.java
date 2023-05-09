package com.chloekarah.postservice.service;

import com.chloekarah.postservice.model.PostObject;
import com.chloekarah.postservice.dto.PostDto;
import com.chloekarah.postservice.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public boolean createPost(PostDto postDto) {

        // TODO: conversion postDto -> post object
        var result = postRepository.addPost(PostObject.fromFibDto(postDto));

        // TODO: return actual database save result
        return result;
    }
}
