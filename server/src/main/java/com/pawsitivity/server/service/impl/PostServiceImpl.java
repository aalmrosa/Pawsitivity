package com.pawsitivity.server.service.impl;

import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.model.Post;
import com.pawsitivity.server.repository.PostRepository;
import com.pawsitivity.server.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Override
    public void save(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        postRepository.save(post);
    }
}