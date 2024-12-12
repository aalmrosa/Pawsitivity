package com.pawsitivity.server.features.post.model;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.pawsitivity.server.dto.Visibility;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable = false)
    private LocalDateTime creationTime;

    private LocalDateTime editedTime;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "creator_id")
    // private UserAccEntity author;

    @Column(nullable = false)
    private String content;

    // @Column(nullable = false)
    private Integer likeCounter;

    // @Column(nullable = false)
    private Integer commentCounter;

    // @Column(nullable = false)
    private Boolean deleted;

    // @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Visibility visibility;


    public Post(LocalDateTime creationTime, String content, Integer likeCounter, Integer commentCounter, Boolean deleted, Visibility visibility){
        this.creationTime = creationTime;
        this.content = content;
        this.likeCounter = likeCounter;
        this.commentCounter = commentCounter;
        this.deleted = deleted;
        this.visibility = visibility;
    }

    @PrePersist
    public void prePersist(){
        if(this.creationTime == null){
            this.creationTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        }
        if(this.likeCounter == null){
            this.likeCounter = 0;
        }
        if(this.commentCounter == null){
            this.commentCounter = 0;
        }
    }

}