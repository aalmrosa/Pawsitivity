package com.pawsitivity.server.service;

import org.springframework.stereotype.Component;

import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.model.UserAccEntity;


@Component
public interface UserAccService {
        
        void create(UserAccDto user) throws Exception;
        void create(UserAccEntity user) throws Exception;
        UserAccEntity get(Long id) throws Exception;
        UserAccEntity get(String username) throws Exception;
        
        void edit(UserAccEntity user);
        void changeUsername(Long id, String username) throws Exception;
        void changeEmail(Long id, String email) throws Exception;
        void changePassword(Long id, String password);
        void deactivate(Long id);
        void activate(Long id);

}
