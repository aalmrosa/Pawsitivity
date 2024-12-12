package com.pawsitivity.server.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {
    
    private Long id;
    private LocalDateTime creationTime;
    private LocalDateTime lastEditedTime;
    private String content;
    private Integer likeCounter;
    private Integer commentCounter;
    private Visibility visibility;

    public PostDto(LocalDateTime creationTime, LocalDateTime lastEditedTime , String content, Integer likeCounter, Integer commentCounter, Visibility visibility){
        this.creationTime = creationTime;
        this.lastEditedTime = lastEditedTime;
        this.content = content;
        this.likeCounter = likeCounter;
        this.commentCounter = commentCounter;
        this.visibility = visibility;
    }
}
