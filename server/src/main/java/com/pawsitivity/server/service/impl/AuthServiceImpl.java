package com.pawsitivity.server.service.impl;

import com.pawsitivity.server.exception.MismatchedInputException;
import com.pawsitivity.server.model.entity.User;
import com.pawsitivity.server.model.request.AuthenticationRequest;
import com.pawsitivity.server.model.request.RegistrationRequest;
import com.pawsitivity.server.model.response.AuthenticationResponse;
import com.pawsitivity.server.model.response.RegistrationResponse;
import com.pawsitivity.server.service.AuthService;
import com.pawsitivity.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public RegistrationResponse register(RegistrationRequest request) throws
            NullPointerException,
            MismatchedInputException
    {
        if (request.password() == null || request.confirmPassword() == null) {
            throw new NullPointerException("Password fields must not be empty.");
        }
        if (!request.password().equals(request.confirmPassword())) {
            throw new MismatchedInputException("Password fields must match.");
        }
        User user = new User.Builder(
                request.email(),
                passwordEncoder.encode(request.password())
        ).build();
        userService.register(user);
        System.out.println("Finished at " + this.getClass());
        return new RegistrationResponse(
                String.valueOf(user.getId()),
                user.getUsername(),
                getRolesAsStringArray(user.getAuthorities())
        );
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws
            AuthenticationException
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        User user = userService.find(request.email()).orElseThrow(
                () -> new BadCredentialsException("Invalid email.")
        );
        return new AuthenticationResponse(
                String.valueOf(user.getId()),
                user.getUsername(),
                getRolesAsStringArray(user.getAuthorities())
        );
    }

    private String[] getRolesAsStringArray(Collection<? extends GrantedAuthority> in) {
        Object[] temp = in.toArray();
        String[] out = new String[temp.length];
        for(int i=0; i<out.length; i++) {
            out[i] = temp[i].toString();
        }
        return out;
    }
}
