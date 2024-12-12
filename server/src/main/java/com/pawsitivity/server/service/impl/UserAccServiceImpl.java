package com.pawsitivity.server.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.mapper.impl.UserAccMapperImpl;
import com.pawsitivity.server.model.UserAccEntity;
import com.pawsitivity.server.repository.UserAccRepository;
import com.pawsitivity.server.service.UserAccService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserAccServiceImpl implements UserAccService {

    private UserAccRepository userAccRepository;
    private UserAccMapperImpl userAccMapperImpl;
    private PasswordEncoder encoder;

    @Override
    public void activate(Long id) {
        try {
            UserAccEntity user = get(id);
            user.setDeactivated(false);
            edit(user);
        } catch(Exception e) {
            return;
        }
    }

    @Override
    public void changeEmail(Long id, String email) throws Exception {
        if (userAccRepository.findByEmail(email).isPresent()) {
            throw new Exception("Email already in use.");
        }
        try {
            UserAccEntity user = get(id);
            user.setEmail(email);
            edit(user);
        } catch(Exception e) {
            return;
        }
    }

    @Override
    public void changePassword(Long id, String password) {
        try {
            UserAccEntity user = get(id);
            user.setPassword(encoder.encode(password));
            edit(user);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void changeUsername(Long id, String username) throws Exception {
        if (userAccRepository.findByUsername(username).isPresent()) {
            throw new Exception("Username already in use.");
        }
        try {
            UserAccEntity user = get(id);
            user.setUsername(username);
            edit(user);
        } catch(Exception e) {
            return;
        }
    }
    
    @Override
    public void create(UserAccEntity user) throws Exception {
        if (userAccRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("Username \"" + user.getUsername() + "\" already in use.");
        }
        if (userAccRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("Email \"" + user.getEmail() + "\" already in use.");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userAccRepository.save(user);
    }

    @Override
    public void create(UserAccDto user) throws Exception {
        if (userAccRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("Username \""+ user.getUsername() +"\" already in use.");
        }
        if (userAccRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("Email \"" + user.getEmail() + "\" already in use.");
        }
        UserAccEntity entity = userAccMapperImpl.mapToEntity(user);
        entity.setPassword(encoder.encode(user.getPassword()));
        userAccRepository.save(entity);
    }

    @Override
    public void deactivate(Long id) {
        try {
            UserAccEntity user = get(id);
            user.setDeactivated(true);
            edit(user);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public UserAccEntity get(Long id) throws Exception {
        Optional<UserAccEntity> user = userAccRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new Exception("User with id \"" + id + "\" not found.");
    }
    
    // input can also be an email
    @Override 
    public UserAccEntity get(String username) throws Exception {
        Optional<UserAccEntity> user = userAccRepository.findByUsername(username); 
        if (user.isEmpty()) {
            user = userAccRepository.findByEmail(username);
        }
        if (user.isPresent()) {
            return user.get();
        }
        throw new Exception("User \"" + username + "\" not found.");
    }

    @Override
    public void edit(UserAccEntity user) {
        userAccRepository.save(user);
    }
    
}
