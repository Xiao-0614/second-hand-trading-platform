package com.chloekarah.postservice.controller;

import com.chloekarah.postservice.dto.PostDto;
import com.chloekarah.postservice.model.PostObject;
import com.chloekarah.postservice.service.PostService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // TODO: spring security auth
    @PostMapping("/create-post")
    public ResponseEntity<Boolean> newPost(@RequestBody PostDto newItem) {

        // TODO: data validation
        if (newItem.getPostName().length() < 10) {
            return ResponseEntity.badRequest().body(false);
        }

        boolean isSuccess = postService.createPost(newItem);
        if (isSuccess) {
            return ResponseEntity.ok(true);
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(409)).body(false);
    }
}
