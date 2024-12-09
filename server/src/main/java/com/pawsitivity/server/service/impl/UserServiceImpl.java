package com.pawsitivity.server.service.impl;

import com.pawsitivity.server.dto.RegistrationDto;
import com.pawsitivity.server.model.UserAccEntity;
import com.pawsitivity.server.repository.UserRepository;
import com.pawsitivity.server.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(RegistrationDto newUser) throws Exception {
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            throw new Exception("Username already in use.");
        }

        UserAccEntity user = new UserAccEntity(
                newUser.getUsername(),
                passwordEncoder.encode(newUser.getPassword())
        );

        userRepository.save(user);
    }
}