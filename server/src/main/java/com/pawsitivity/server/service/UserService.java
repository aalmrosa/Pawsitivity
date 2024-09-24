package com.pawsitivity.server.service;

import com.pawsitivity.server.dto.RegistrationDto;
import com.pawsitivity.server.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    void save(RegistrationDto user) throws UserAlreadyExistsException;
}
