package com.pawsitivity.server.features.post.model;
import java.time.LocalDateTime;

import com.pawsitivity.server.features.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime creationTime;

    private LocalDateTime editedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer likeCounter;
    @Column(nullable = false)
    private Integer commentCounter;

    @Column(nullable = false)
    private Boolean deleted;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    public enum Visibility {
        PUBLIC,
        FRIENDS_ONLY,
        PRIVATE
    }
}