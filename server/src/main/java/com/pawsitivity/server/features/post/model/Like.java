package com.pawsitivity.server.features.post.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // @Column(nullable = false)
    // private Post post;

    // @Column(nullable = false)
    // private User author;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    public enum ContentType {
        POST,
        COMMENT
    }

    @Column(nullable = false)
    private LocalDateTime time;
}
