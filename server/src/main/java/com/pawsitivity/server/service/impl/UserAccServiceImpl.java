package com.pawsitivity.server.service.impl;

import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.mapper.impl.UserAccountMapperImpl;
import com.pawsitivity.server.repository.UserAccRepository;
import com.pawsitivity.server.service.UserAccService;

public class UserAccServiceImpl implements UserAccService {

    private UserAccRepository userAccountRepository;
    private UserAccountMapperImpl userAccountMapperImpl;

    public UserAccServiceImpl(
        UserAccRepository userAccountRepository, 
        UserAccountMapperImpl userAccountMapperImpl) {
            this.userAccountRepository = userAccountRepository;
            this.userAccountMapperImpl = userAccountMapperImpl;
    }

    @Override
    public void createUserAccount(UserAccDto userAccountDto) {

    }
    
}
