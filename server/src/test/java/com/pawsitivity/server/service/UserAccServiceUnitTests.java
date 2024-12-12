package com.pawsitivity.server.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pawsitivity.server.TestDataUtil;
import com.pawsitivity.server.dto.UserAccDto;
import com.pawsitivity.server.model.UserAccEntity;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserAccServiceUnitTests {

    private UserAccService underTest;

    @Autowired
    public UserAccServiceUnitTests(UserAccService underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testUserAccountCanBeCreatedByEntityAndRetrievedById() {
        UserAccEntity user = TestDataUtil.userAccEntityA();
        user.setId(1L);
        try {
            underTest.create(user);
            UserAccEntity result = underTest.get(1L);
            assertEquals(result, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUserAccountCanBeCreatedByDtoAndRetrievedByUsername() {
        UserAccDto user = TestDataUtil.userAccDtoA();
        try {
            underTest.create(user);
            UserAccEntity result = underTest.get(user.getUsername());
            assertEquals(result.getUsername(), user.getUsername());
            assertEquals(result.getEmail(), user.getEmail());
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test failed.");
        }
    }

    @Test
    public void testUserAccountCanBeEdited() {
        UserAccEntity user = TestDataUtil.userAccEntityA();
        user.setId(1L);
        try {
            underTest.create(user);
            //email
            underTest.changeEmail(1L, "EMAIL_UPDATED");
            assertEquals(underTest.get(1L).getEmail(), "EMAIL_UPDATED");
            //password
            underTest.changePassword(1L, "PASS_UPDATED");
            assertNotEquals(user.getPassword(), underTest.get(1L).getPassword());
            //deactivate
            underTest.deactivate(1L);
            assertEquals(true, underTest.get(1L).getDeactivated());
            //activate
            underTest.activate(1L);
            assertEquals(false, underTest.get(1L).getDeactivated());
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssertionError("Test failed.");
        }
    }
}
