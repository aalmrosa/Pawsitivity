package com.pawsitivity.server.controller;

import com.pawsitivity.server.exception.MismatchedInputException;
import com.pawsitivity.server.model.entity.User;
import com.pawsitivity.server.model.request.AuthenticationRequest;
import com.pawsitivity.server.model.request.RegistrationRequest;
import com.pawsitivity.server.model.response.RegistrationResponse;
import com.pawsitivity.server.service.AuthService;
import com.pawsitivity.server.service.UserServiceV2;
import com.pawsitivity.server.service.impl.UserServiceImplV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.management.InvalidAttributeValueException;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthControllerV2 {

    @Autowired
    private UserServiceV2 userServiceV2;

    @Autowired
    private AuthService authService;

    @PostMapping(path="/login")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok("");
    }

    @PostMapping(path="/signup")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        RegistrationResponse response = authService.register(request);
        return ResponseEntity.ok("yep");
    }

    @GetMapping(path="/self")
    public ResponseEntity<User> identifyUser(@RequestBody String value) {
        User user = userServiceV2.find(value).get();
        return ResponseEntity.ok(user);
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
