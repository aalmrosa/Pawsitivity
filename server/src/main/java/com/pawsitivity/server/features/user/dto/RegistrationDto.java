package com.pawsitivity.server.features.user.dto;

import com.pawsitivity.server.validation.PasswordMatches;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@PasswordMatches(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "Passwords must match"
)
public class RegistrationDto {
    @NotEmpty(message = "Username Required")
    private String username;
    @NotEmpty(message = "Password Required")
    private String password;
    @NotEmpty(message = "Password Confirmation Required")
    private String confirmPassword;
}