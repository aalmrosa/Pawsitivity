package com.pawsitivity.server.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    
    private LocalDateTime creationTime;
    private LocalDateTime editedTime;
    private String content;
    private Integer likeCounter;
    private Integer commentCounter;

}
