package com.pawsitivity.server;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.model.UserAccEntity;

public class TestDataUtil {

    public static UserAccEntity userAccEntityA() {
        UserAccEntity user = new UserAccEntity("testUserA", "a@test.com", "passA");
        user.setTimeOfCreation(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        user.setLastEdit(user.getTimeOfCreation());
        user.setDeactivated(false);
        return user;
    }
    
    public static UserAccEntity userAccEntityB() {
        return new UserAccEntity("testUserB", "b@test.com", "passB");
    }
    
    public static UserAccEntity userAccEntityC() {
        return new UserAccEntity("testUserC", "c@test.com", "passC");
    }

    public static UserAccDto userAccDtoA() {
        return new UserAccDto("testUserA", "a@test.com", "passA");
    }
    
    public static UserAccDto userAccDtoB() {
        return new UserAccDto("testUserB", "b@test.com", "passB");
    }
    
    public static UserAccDto userAccDtoC() {
        return new UserAccDto("testUserC", "c@test.com", "passC");
    }

}
