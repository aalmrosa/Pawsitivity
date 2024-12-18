package com.pawsitivity.server.controller;

import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.exceptions.user.UserAccountParameterException;
import com.pawsitivity.server.service.UserAccService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserAccService userAccService;
    
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserAccService userAccService) {
        this.authenticationManager = authenticationManager;
        this.userAccService = userAccService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAccDto request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()) {
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User could not be logged in", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserAccDto request) {
        try {
            userAccService.create(request);
        } catch (UserAccountParameterException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
    
}
