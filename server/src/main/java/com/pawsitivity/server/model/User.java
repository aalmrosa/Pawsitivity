package com.pawsitivity.server.model;

import java.io.Serializable;
import java.util.Set;

// import com.pawsitivity.server.features.post.model.Post;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
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

    // @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    // private Set<Post> posts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}