package com.pawsitivity.server.features.user.service;

import com.pawsitivity.server.exception.UserAlreadyExistsException;
import com.pawsitivity.server.features.user.dto.RegistrationDto;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
    void save(RegistrationDto user) throws UserAlreadyExistsException;
}
