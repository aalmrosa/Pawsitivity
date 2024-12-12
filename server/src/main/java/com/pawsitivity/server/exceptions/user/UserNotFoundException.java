package com.pawsitivity.server.exceptions.user;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User not found");
    }

    public UserNotFoundException(Long id) {
        super("User with id \"" + id + "\" not found");
    }

    public UserNotFoundException(String identifier) {
        super("User \"" + identifier + "\" not found.");
    }
    
}
