package com.pawsitivity.server;

import com.pawsitivity.server.model.User;

public class TestDataUtil {
    
    public static User createTestUserA() {
        return new User("testUserA", "passwordA");
    }

    public static User createTestUserB() {
        return new User("testUserB", "passwordB");
    }

    public static User createTestUserC() {
        return new User("testUserC", "passwordC");
    }
}
