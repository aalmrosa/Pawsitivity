package com.pawsitivity.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.service.PostService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/post")
public class PostController {
    private AuthenticationManager authenticationManager;
    private PostService postService;

    public PostController(AuthenticationManager authenticationManager, PostService postService){
        this.authenticationManager = authenticationManager;
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody PostDto postDto){
        try{
            postService.createPost(postDto);
        }
        catch(Exception e){
            //TODO: Change http status
            return new ResponseEntity<>("Unable to create post", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Post created", HttpStatus.CREATED);
    }

}
