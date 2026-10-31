package com.pawsitivity.server.model.request;

import jakarta.validation.constraints.NotEmpty;

public record AuthenticationRequest(
        @NotEmpty(message="Field cannot be empty.")
        String email,

        @NotEmpty(message="Field cannot be empty.")
        String password
) {

}