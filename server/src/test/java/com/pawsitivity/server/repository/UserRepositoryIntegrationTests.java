package com.pawsitivity.server.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pawsitivity.server.TestDataUtil;
import com.pawsitivity.server.model.UserAccEntity;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryIntegrationTests {
    
    private UserRepository underTest;

    @Autowired
    public UserRepositoryIntegrationTests(UserRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testUserCanBeCreatedAndRetrieved() {
        UserAccEntity user = TestDataUtil.createTestUserA();
        underTest.save(user);
        Optional<UserAccEntity> result = underTest.findById(user.getId());
        assert(result).isPresent();
        assert(user).equals(result.get());
    }

    @Test
    public void testMultipleUsersCanBeCreatedAndRetrieved() {
        List<UserAccEntity> users = new ArrayList<>();
        users.add(TestDataUtil.createTestUserA());
        users.add(TestDataUtil.createTestUserB());
        users.add(TestDataUtil.createTestUserC());
        users.forEach(user -> underTest.save(user));
        List<UserAccEntity> result = underTest.findAll();
        assert(users).equals(result);
    }

    @Test
    public void testUserCanBeUpdated() {
        UserAccEntity user = TestDataUtil.createTestUserA();
        underTest.save(user);
        user.setUsername("UPDATED");
        underTest.save(user);
        Optional<UserAccEntity> result = underTest.findById(user.getId());
        assert(result).isPresent();
        assert(user).equals(result.get());
    }

    @Test
    public void testUserCanBeDeleted() {
        UserAccEntity user = TestDataUtil.createTestUserA();
        underTest.save(user);
        underTest.delete(user);
        Optional<UserAccEntity> result = underTest.findById(user.getId());
        assert(result).isEmpty(); 
    }
}
