package com.pawsitivity.server.service.impl;

import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.repository.PostRepository;
import com.pawsitivity.server.service.PostService;

public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto postDto){

    }
}
