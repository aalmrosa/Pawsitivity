package com.pawsitivity.server.dto;

import java.sql.Timestamp;

public class UserAccountDto {

    private String username;
    
    private String email;
    
    private String password;
    
    private Timestamp timeOfCreation;
    
    private Timestamp lastEdit;
    
    private Boolean deactivated;

}
