package com.pawsitivity.server.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Component;

import com.pawsitivity.server.dto.PostDto;

@Component
public interface PostService {
    void createPost(PostDto postDto) throws Exception;
    PostDto getPost(Long id);
    PostDto editPost(Long id, String content);
    void incrementLike(Long id);
}
