package com.pawsitivity.server.model.response;

public record RegistrationResponse(
        String id,
        String email,
        String[] roles
) {

}