package com.pawsitivity.server;

import com.pawsitivity.server.model.UserAccount;

public class TestDataUtil {
    
    public static UserAccount createTestUserA() {
        return new UserAccount("testUserA", "passwordA");
    }

    public static UserAccount createTestUserB() {
        return new UserAccount("testUserB", "passwordB");
    }

    public static UserAccount createTestUserC() {
        return new UserAccount("testUserC", "passwordC");
    }
}
