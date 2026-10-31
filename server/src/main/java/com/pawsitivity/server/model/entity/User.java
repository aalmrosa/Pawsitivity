package com.pawsitivity.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails {

    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(name="created_at")
    @UpdateTimestamp
    private String createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private String updatedAt;

    @Column
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    private User(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
        this.authorities = builder.getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public static class Builder {
        private final String email;
        private final String password;

        @Getter
        private Collection<GrantedAuthority> authorities;

        public Builder(String email, String password) {
            this.email = email;
            this.password = password;
            this.authorities = new ArrayList<>();
            authorities.add(Authority.USER);
        }

        public Builder addAuthority(String authority) {
            this.authorities.add(Authority.valueOf(authority));
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}