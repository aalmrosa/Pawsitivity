package com.pawsitivity.server.features.post.model;

import java.time.LocalDateTime;

import com.pawsitivity.server.features.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long contentId;

    @Column(nullable = false)
    private User author;

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
