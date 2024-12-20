package com.pawsitivity.server.controller;

import com.pawsitivity.server.dto.RegistrationDto;
import com.pawsitivity.server.dto.UserDto;
import com.pawsitivity.server.service.UserService;

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
    private UserService userService;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDto registrationDto) {
        try {
            userService.save(registrationDto);
        } catch (Exception e) {
            return new ResponseEntity<>("Username is taken", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
