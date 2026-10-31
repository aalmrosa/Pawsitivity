package com.pawsitivity.server.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Authority implements GrantedAuthority {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final GrantedAuthority authority;
    Authority(String authority) {
        this.authority = new SimpleGrantedAuthority(authority);
    }

    @Override
    public String getAuthority() {
        return this.authority.toString();
    }
}
