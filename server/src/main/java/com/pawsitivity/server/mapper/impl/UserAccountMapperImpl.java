package com.pawsitivity.server.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pawsitivity.server.dto.UserAccountDto;
import com.pawsitivity.server.mapper.Mapper;
import com.pawsitivity.server.model.UserAccEntity;

@Component
public class UserAccountMapperImpl implements Mapper<UserAccEntity, UserAccountDto> {

    private ModelMapper modelMapper;

    public UserAccountMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserAccEntity mapToEntity(UserAccountDto userAccountDto) {
        return modelMapper.map(userAccountDto, UserAccEntity.class);
    }

    @Override
    public UserAccountDto mapToDto(UserAccEntity userAccountModel) {
        return modelMapper.map(userAccountModel, UserAccountDto.class);
    }

}
