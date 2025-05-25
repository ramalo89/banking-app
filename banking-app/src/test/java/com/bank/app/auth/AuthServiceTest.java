package com.bank.app.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private AuthService authService;
    private File tempFile;

    @BeforeEach
    void setUp() {
        // Create a temp file for testing user storage
        try {
            tempFile = File.createTempFile("test-users", ".txt");
            tempFile.deleteOnExit(); // Automatically delete after tests
        } catch (Exception e) {
            fail("Failed to create temp user file: " + e.getMessage());
        }

        authService = new AuthService(tempFile.getAbsolutePath());
        authService.register("testuser", "testpass123");
    }

    @Test
    void testSuccessfulLogin() {
        assertTrue(authService.login("testuser", "testpass123"));
    }

    @Test
    void testFailedLoginWrongPassword() {
        assertFalse(authService.login("testuser", "wrongpass"));
    }

    @Test
    void testFailedLoginUnknownUser() {
        assertFalse(authService.login("unknown", "testpass123"));
    }

    @Test
    void testDuplicateRegistration() {
        authService.register("testuser", "testpass123");
        assertTrue(authService.login("testuser", "testpass123"));
    }
}
