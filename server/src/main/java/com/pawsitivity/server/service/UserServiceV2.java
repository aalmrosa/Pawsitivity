package com.pawsitivity.server.service;

import com.pawsitivity.server.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserServiceV2 {
    Optional<User> find(String value);
    void register(User user);
}
