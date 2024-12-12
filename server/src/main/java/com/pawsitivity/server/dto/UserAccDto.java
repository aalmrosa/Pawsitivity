package com.pawsitivity.server.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccDto {

    private Long id;

    private String username;
    
    private String email;
    
    private String password;
    
    private LocalDateTime timeOfCreation;
    
    private LocalDateTime lastEdit;
    
    private Boolean deactivated;

    public UserAccDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
