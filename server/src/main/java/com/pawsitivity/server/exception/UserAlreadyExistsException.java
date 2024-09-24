package com.pawsitivity.server.exception;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String username) {
        super(String.format("User with name %s already exists", username));
    }
}