package com.pawsitivity.server.service.impl;

import com.pawsitivity.server.model.entity.User;
import com.pawsitivity.server.repository.UserRepository;
import com.pawsitivity.server.service.UserServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplV2 implements UserServiceV2 {

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
            throw new DuplicateKeyException("Email already registered.");
        }
        System.out.println("Finished at " + this.getClass());
        userRepository.save(user);
    }
}
