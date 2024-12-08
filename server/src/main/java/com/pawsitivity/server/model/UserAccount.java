package com.pawsitivity.server.model;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="user_accounts")
public class UserAccount {

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
    private Timestamp timeOfCreation;

    @Column(name="last_edit")
    private Timestamp lastEdit;

    private Boolean deactivated;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
        setDefaults(this);
    }

    private static void setDefaults(UserAccount userAccount) {
        userAccount.setDeactivated(false);
    }
}