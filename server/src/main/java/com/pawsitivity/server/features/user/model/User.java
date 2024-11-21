package com.pawsitivity.server.features.user.model;

import java.util.Set;

import com.pawsitivity.server.features.post.model.Post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private Set<Post> posts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}