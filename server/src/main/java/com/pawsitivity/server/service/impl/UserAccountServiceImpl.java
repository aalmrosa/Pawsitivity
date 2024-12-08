package com.pawsitivity.server.service.impl;

import com.pawsitivity.server.dto.UserAccountDto;
import com.pawsitivity.server.mapper.impl.UserAccountMapperImpl;
import com.pawsitivity.server.repository.UserAccountRepository;
import com.pawsitivity.server.service.UserAccountService;

public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;
    private UserAccountMapperImpl userAccountMapperImpl;

    public UserAccountServiceImpl(
        UserAccountRepository userAccountRepository, 
        UserAccountMapperImpl userAccountMapperImpl) {
            this.userAccountRepository = userAccountRepository;
            this.userAccountMapperImpl = userAccountMapperImpl;
    }

    @Override
    public void createUserAccount(UserAccountDto userAccountDto) {

    }
    
}
