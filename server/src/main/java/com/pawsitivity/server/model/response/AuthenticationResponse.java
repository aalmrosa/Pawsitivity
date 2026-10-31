package com.pawsitivity.server.model.response;

public record AuthenticationResponse(
        String id,
        String email,
        String[] roles
) {

}