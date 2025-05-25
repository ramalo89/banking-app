package com.bank.app.auth;

import com.bank.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService();
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
