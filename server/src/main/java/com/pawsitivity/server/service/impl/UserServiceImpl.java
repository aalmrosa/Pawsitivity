package com.pawsitivity.server.service.impl;

import com.pawsitivity.server.model.entity.User;
import com.pawsitivity.server.repository.UserRepository;
import com.pawsitivity.server.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> find(String field) {
        return userRepository.findByEmail(field)
                .or(() -> userRepository.findById(Long.parseLong(field)));
    }

    @Override
    public void register(User user) {
        if (userRepository.findByEmail(user.getUsername()).isPresent()) {
            throw new DuplicateKeyException("Email already in use.");
        }
        userRepository.save(user);
    }
}