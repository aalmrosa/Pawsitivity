package com.pawsitivity.server.mapper.impl;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.features.post.model.Post;
import com.pawsitivity.server.mapper.Mapper;

@Component
public class PostMapperImpl implements Mapper<Post, PostDto> {

    private ModelMapper modelMapper;

    public PostMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto mapToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public Post mapToEntity(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }

}