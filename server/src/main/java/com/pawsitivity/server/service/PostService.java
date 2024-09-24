package com.pawsitivity.server.service;

import com.pawsitivity.server.dto.PostDto;
import org.springframework.stereotype.Component;

@Component
public interface PostService {
    void save(PostDto postDto);
}
