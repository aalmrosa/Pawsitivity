package com.pawsitivity.server.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.exceptions.user.UserAccountParameterException;
import com.pawsitivity.server.exceptions.user.UserNotFoundException;
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
    public void changeEmail(Long id, String email) throws UserAccountParameterException {
        if (userAccRepository.findByEmail(email).isPresent()) {
            throw new UserAccountParameterException("Email", email);
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
    public void changeUsername(Long id, String username) throws UserAccountParameterException {
        if (userAccRepository.findByUsername(username).isPresent()) {
            throw new UserAccountParameterException("Username", username);
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
    public void create(UserAccEntity user) throws UserAccountParameterException {
        if (userAccRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAccountParameterException("Username", user.getUsername());
        }
        if (userAccRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAccountParameterException("Email", user.getEmail());
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userAccRepository.save(user);
    }

    @Override
    public void create(UserAccDto user) throws UserAccountParameterException {
        if (userAccRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAccountParameterException("Username", user.getUsername());
        }
        if (userAccRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAccountParameterException("Email", user.getEmail());
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
    public UserAccEntity get(Long id) throws UserNotFoundException {
        Optional<UserAccEntity> user = userAccRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException(id);
    }
    
    // input can also be an email
    @Override 
    public UserAccEntity get(String username) throws UserNotFoundException {
        Optional<UserAccEntity> user = userAccRepository.findByUsername(username); 
        if (user.isEmpty()) {
            user = userAccRepository.findByEmail(username);
        }
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException(username);
    }

    @Override
    public void edit(UserAccEntity user) {
        userAccRepository.save(user);
    }
    
}
