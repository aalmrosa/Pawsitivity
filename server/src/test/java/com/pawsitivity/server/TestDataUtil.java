package com.pawsitivity.server;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import com.pawsitivity.server.features.post.model.Post;
import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.dto.Visibility;
import com.pawsitivity.server.model.UserAccEntity;

public class TestDataUtil {
    
    public static UserAccEntity createTestUserA() {
        return new UserAccEntity("testUserA", "passwordA");
    }

    public static UserAccEntity createTestUserB() {
        return new UserAccEntity("testUserB", "passwordB");
    }

    public static UserAccEntity createTestUserC() {
        return new UserAccEntity("testUserC", "passwordC");
    }

    public static PostDto createTestPostA(){
        return new PostDto(
            LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), 
            LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), 
            "CUPCAKE", 
            0, 
            0, 
            Visibility.PRIVATE
        );
    }

    public static PostDto createTestPostB(){
        return new PostDto(
            LocalDateTime.of(2024, 1, 14, 5, 20,20), 
            LocalDateTime.of(2026, 2, 11, 12, 53, 5) ,
            "OI", 
            20000, 
            1025, 
            Visibility.PUBLIC
        );
    }

    public static PostDto createTestPostC(){
        return new PostDto(
            LocalDateTime.of(2022, 5, 2, 12, 22,42),
            LocalDateTime.of(2062, 3, 25, 15, 02,51),
            "IAMSADFGSAFSDUFHSDIFHAUISHFAIHFASIF",
            5021, 
            105,
            Visibility.FRIENDS_ONLY);
    }
}
