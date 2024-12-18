package com.pawsitivity.server.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pawsitivity.server.model.properties.UserRoles;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="user_accounts")
public class UserAccEntity implements UserDetails {

    @Id
    @SequenceGenerator(
        name = "seq_user",
        sequenceName = "seq_user",
        allocationSize = 1
        )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_user"
    )
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name="time_of_creation")
    private LocalDateTime timeOfCreation;

    @Column(name="last_edit")
    private LocalDateTime lastEdit;

    private Boolean deactivated = false;

    private Boolean enabled = false;

    @Enumerated(EnumType.STRING)
    private UserRoles userRole;

    public UserAccEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @PrePersist
    public void prePersist() {
        if (this.lastEdit == null) {
            this.lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        }
        if (this.timeOfCreation == null) {
            this.timeOfCreation = this.lastEdit;
        }
        if (this.userRole == null) {
            this.userRole = UserRoles.USER;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }
}