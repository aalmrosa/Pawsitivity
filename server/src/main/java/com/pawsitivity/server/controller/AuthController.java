package com.pawsitivity.server.controller;

import com.pawsitivity.server.exception.MismatchedInputException;
import com.pawsitivity.server.model.request.AuthenticationRequest;
import com.pawsitivity.server.model.request.RegistrationRequest;
import com.pawsitivity.server.model.response.RegistrationResponse;
import com.pawsitivity.server.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request) {
        RegistrationResponse response = authService.register(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> response = null;
        if (e instanceof NullPointerException) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        if (e instanceof MismatchedInputException) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        if (e instanceof AuthenticationException) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        if (response == null) {
            response = new ResponseEntity<>(
                    "Unknown server exception at "+ this.getClass() + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return response;
    }
}
