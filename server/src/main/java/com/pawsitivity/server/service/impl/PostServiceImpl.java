package com.pawsitivity.server.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.features.post.model.Post;
import com.pawsitivity.server.mapper.Mapper;
import com.pawsitivity.server.repository.PostRepository;
import com.pawsitivity.server.service.PostService;

@Service
public class PostServiceImpl implements PostService{
    private Mapper<Post, PostDto> mapper;
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository, Mapper<Post, PostDto> mapper){
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public void createPost(PostDto postDto){
        postRepository.save(mapper.mapToEntity(postDto));
    }

    @Override
    public PostDto getPost(Long id){
        return mapper.mapToDto(postRepository.findById(id).get());
    }

    @Override
    public PostDto editPost(Long id, String content) {
        Post post = postRepository.findById(id).get();
        post.setContent(content);
        postRepository.save(post);
        return mapper.mapToDto(post);
    }

    @Override
    public void incrementLike(Long id) {
        Post post = postRepository.findById(id).get();
        post.setLikeCounter(post.getLikeCounter()+1);
        postRepository.save(post);
    }

}
