package com.pawsitivity.server.service;
import org.springframework.stereotype.Component;
import com.pawsitivity.server.dto.PostDto;

@Component
public interface PostService {
    void createPost(PostDto postDto);
    PostDto getPost(Long id);
    PostDto editPost(Long id, String content);
    void incrementLike(Long id);
}
