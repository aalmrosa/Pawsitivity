package com.pawsitivity.server.service;

import org.springframework.stereotype.Component;

import com.pawsitivity.server.dto.UserAccountDto;
import com.pawsitivity.server.model.UserAccEntity;


@Component
public interface UserAccountService {
        void createUserAccount(UserAccountDto userAccountDto);
}
