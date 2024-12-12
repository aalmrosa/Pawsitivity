package com.pawsitivity.server.service;

import org.springframework.stereotype.Component;

import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.exceptions.user.UserAccountParameterException;
import com.pawsitivity.server.exceptions.user.UserNotFoundException;
import com.pawsitivity.server.model.UserAccEntity;


@Component
public interface UserAccService {
        
        void create(UserAccDto user) throws UserAccountParameterException;
        void create(UserAccEntity user) throws UserAccountParameterException;
        UserAccEntity get(Long id) throws UserNotFoundException;
        UserAccEntity get(String username) throws UserNotFoundException;
        
        void edit(UserAccEntity user);
        void changeUsername(Long id, String username) throws UserAccountParameterException;
        void changeEmail(Long id, String email) throws UserAccountParameterException;
        void changePassword(Long id, String password);
        void deactivate(Long id);
        void activate(Long id);

}
