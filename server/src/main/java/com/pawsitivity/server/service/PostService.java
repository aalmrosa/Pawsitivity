package com.pawsitivity.server.service;

import org.springframework.stereotype.Component;

import com.pawsitivity.server.dto.PostDto;

@Component
public interface PostService {
    void createPost(PostDto postDto) throws Exception;
}
