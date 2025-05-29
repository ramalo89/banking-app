package com.bank.app.auth.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AuthService.
 * Uses Mockito to verify delegation to UserService.
 */
public class AuthServiceTest {

    private UserService mockUserService;
    private AuthService authService;

    @BeforeEach
    void setup() {
        mockUserService = mock(UserService.class);
        authService = new AuthService(mockUserService);
    }

    @Test
    void testLoginDelegationSuccess() {
        when(mockUserService.login("john", "password123")).thenReturn(true);

        boolean result = authService.login("john", "password123");

        assertTrue(result);
        verify(mockUserService, times(1)).login("john", "password123");
    }

    @Test
    void testLoginDelegationFailure() {
        when(mockUserService.login("john", "wrongpass")).thenReturn(false);

        boolean result = authService.login("john", "wrongpass");

        assertFalse(result);
        verify(mockUserService, times(1)).login("john", "wrongpass");
    }

    @Test
    void testRegisterDelegation() {
        authService.register("newuser", "newpass");

        verify(mockUserService, times(1)).register("newuser", "newpass");
    }
}
