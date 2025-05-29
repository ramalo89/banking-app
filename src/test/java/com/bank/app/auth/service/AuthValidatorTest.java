package com.bank.app.auth.service;

import com.bank.app.auth.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AuthValidator.
 * Covers username, password, and duplicate checks.
 */
public class AuthValidatorTest {

    private AuthValidator validator;

    @BeforeEach
    void setup() {
        validator = new AuthValidator();
    }

    @Test
    void testValidUsername() {
        assertTrue(validator.isUsernameValid("user123"));
    }

    @Test
    void testInvalidUsernameTooShort() {
        assertFalse(validator.isUsernameValid("ab"));
    }

    @Test
    void testInvalidUsernameNull() {
        assertFalse(validator.isUsernameValid(null));
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isPasswordValid("secure123"));
    }

    @Test
    void testInvalidPasswordTooShort() {
        assertFalse(validator.isPasswordValid("123"));
    }

    @Test
    void testInvalidPasswordNull() {
        assertFalse(validator.isPasswordValid(null));
    }

    @Test
    void testDuplicateUserExists() {
        Map<String, User> users = new HashMap<>();
        users.put("john", new User("john", "pass123"));

        assertTrue(validator.isDuplicateUser("john", users));
    }

    @Test
    void testDuplicateUserDoesNotExist() {
        Map<String, User> users = new HashMap<>();
        users.put("alice", new User("alice", "pass123"));

        assertFalse(validator.isDuplicateUser("bob", users));
    }
}
