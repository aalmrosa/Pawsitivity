package com.pawsitivity.server.service;

import com.pawsitivity.server.model.request.AuthenticationRequest;
import com.pawsitivity.server.model.request.RegistrationRequest;
import com.pawsitivity.server.model.response.AuthenticationResponse;
import com.pawsitivity.server.model.response.RegistrationResponse;
import org.springframework.stereotype.Component;

@Component
public interface AuthService {
    RegistrationResponse register(RegistrationRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
