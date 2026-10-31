package com.pawsitivity.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MismatchedInputException extends RuntimeException {
    public MismatchedInputException(String message) {
        super(message);
    }
}
