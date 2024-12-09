package com.pawsitivity.server.service;

import org.springframework.stereotype.Component;

import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.model.UserAccEntity;


@Component
public interface UserAccService {
        void createUserAccount(UserAccDto userAccountDto);
}
