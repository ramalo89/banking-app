package com.bank.app.auth.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.app.repository.UserRepository;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService userService;
    private File tempFile;

    @BeforeEach
    void setUp() throws Exception {
        tempFile = File.createTempFile("test-users", ".txt");
        tempFile.deleteOnExit();
        userService = new UserService(new UserRepository(tempFile.getAbsolutePath()));
        userService.register("testuser", "testpass123");
    }

    @Test
    void testSuccessfulLogin() {
        assertTrue(userService.login("testuser", "testpass123"));
    }

    @Test
    void testFailedLoginWrongPassword() {
        assertFalse(userService.login("testuser", "wrongpass"));
    }

    @Test
    void testFailedLoginUnknownUser() {
        assertFalse(userService.login("unknown", "testpass123"));
    }

    @Test
    void testDuplicateRegistration() {
        userService.register("testuser", "testpass123");
        assertTrue(userService.login("testuser", "testpass123"));
    }
}

