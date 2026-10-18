package com.pawsitivity.server.model.request;

import jakarta.validation.constraints.NotEmpty;

public record RegistrationRequest(
        @NotEmpty(message="Field cannot be empty.")
        String email,

        @NotEmpty(message="Field cannot be empty.")
        String password,

        @NotEmpty(message="Field cannot be empty.")
        String confirmPassword
) {

}