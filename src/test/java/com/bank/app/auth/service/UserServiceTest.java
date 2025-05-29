package com.bank.app.auth.service;

import com.bank.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for UserService.
 * Uses a temporary file-based UserRepository for isolation.
 */
public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp(@TempDir File tempDir) throws Exception {
        File tempFile = new File(tempDir, "test-users.txt");
        UserRepository userRepository = new UserRepository(tempFile.getAbsolutePath());
        userService = new UserService(userRepository);

        // Pre-register a user
        userService.register("testuser", "testpass123");
    }

    @Test
    void testSuccessfulLogin() {
        assertTrue(userService.login("testuser", "testpass123"));
    }

    @Test
    void testLoginWrongPassword() {
        assertFalse(userService.login("testuser", "wrongpass"));
    }

    @Test
    void testLoginUnknownUser() {
        assertFalse(userService.login("nonexistent", "testpass123"));
    }

    @Test
    void testDuplicateRegistration() {
        // Attempt to register same user again
        userService.register("testuser", "testpass123"); // Should not overwrite
        assertTrue(userService.login("testuser", "testpass123"));
    }

    @Test
    void testNewUserRegistrationSuccess() {
        userService.register("newuser", "newpass123");
        assertTrue(userService.login("newuser", "newpass123"));
    }

    @Test
    void testRegistrationWithShortUsername() {
        userService.register("ab", "validpass");
        assertFalse(userService.login("ab", "validpass")); // Not stored due to invalid username
    }

    @Test
    void testRegistrationWithShortPassword() {
        userService.register("validuser", "123");
        assertFalse(userService.login("validuser", "123")); // Not stored due to invalid password
    }

    @Test
    void testRateLimiterBlocksAfterMaxAttempts() {
        for (int i = 0; i < 5; i++) {
            userService.login("testuser", "wrongpass");
        }
        assertFalse(userService.login("testuser", "testpass123")); // Blocked now
    }

    @Test
    void testRateLimiterResetAfterSuccess() {
        for (int i = 0; i < 3; i++) {
            userService.login("testuser", "wrongpass");
        }
        assertTrue(userService.login("testuser", "testpass123")); // Success resets attempts
        assertTrue(userService.login("testuser", "testpass123")); // Should still succeed
    }
}
