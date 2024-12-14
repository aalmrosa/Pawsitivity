package com.pawsitivity.server.features.post.model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable = false)
    // private Post post;

    // @Column(nullable = false)
    // private User author;

    // @Column(nullable = false)
    private LocalDateTime creationTime;

    // @Column(nullable = false)
    private LocalDateTime lastEditedTime;

    // @Column(nullable = false)
    private String content;

    // @Column(nullable = false)
    private Boolean deleted;
}
