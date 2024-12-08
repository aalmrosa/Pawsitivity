package com.pawsitivity.server.service;

import com.pawsitivity.server.dto.RegistrationDto;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
    void save(RegistrationDto user) throws Exception;
}
