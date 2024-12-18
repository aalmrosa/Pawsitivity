package com.pawsitivity.server.security;

import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pawsitivity.server.exceptions.user.UserNotFoundException;
import com.pawsitivity.server.model.UserAccEntity;
import com.pawsitivity.server.service.UserAccService;


@AllArgsConstructor
@Service
public class UserAccDetailsService implements UserDetailsService {
    
    private UserAccService userAccService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccEntity user;
        try {
            user = userAccService.get(username);
        } catch(UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
        return new User(
            user.getUsername(), 
            user.getPassword(), 
            user.getAuthorities()
        );
    }
}
