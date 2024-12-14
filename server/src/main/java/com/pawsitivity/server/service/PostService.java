package com.pawsitivity.server.service;

import org.springframework.stereotype.Component;
import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.dto.Visibility;

@Component
public interface PostService {
    void createPost(PostDto postDto);
    PostDto getPost(Long id);
    PostDto editPost(Long id, String content);
    PostDto changeVisibility(Long id, Visibility visibility);
    void incrementLike(Long id);
    void unlike(Long id);
}
