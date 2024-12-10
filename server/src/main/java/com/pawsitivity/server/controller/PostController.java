package com.pawsitivity.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Post created", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable("id") Long id){
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<PostDto> editPost(@PathVariable("id") Long id, @RequestBody String content){
        //send only string not json
        return ResponseEntity.ok(postService.editPost(id, content));
    }

    @PutMapping("/like")
    public void incrementLike(@PathVariable("id") Long id){
        postService.incrementLike(id);
    }

}
