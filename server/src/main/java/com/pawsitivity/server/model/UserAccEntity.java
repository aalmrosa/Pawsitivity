package com.pawsitivity.server.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="user_accounts")
public class UserAccEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private Boolean deactivated;

    public UserAccEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @PrePersist
    public void prePersist() {
        if (this.deactivated == null) {
            this.deactivated = false;
        }
        if (this.lastEdit == null) {
            this.lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        }
        if (this.timeOfCreation == null) {
            this.timeOfCreation = this.lastEdit;
        }
    }
}