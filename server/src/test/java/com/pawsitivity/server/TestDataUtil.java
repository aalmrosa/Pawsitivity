package com.pawsitivity.server;

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
}
