package com.pawsitivity.server.exceptions.user;

public class UserAccountParameterException extends Exception {
    
    public UserAccountParameterException(String message) {
        super(message);
    }

    public UserAccountParameterException(String type, String identifier) {
        super(String.format("%s \"%s\" already in use.", type, identifier));
    }

}
