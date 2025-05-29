package com.bank.app.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for InputValidator utility.
 * Validates username and password requirements.
 */
public class InputValidatorTest {

    @Test
    void testValidUsername() {
        assertTrue(InputValidator.isUsernameValid("user123"));
        assertTrue(InputValidator.isUsernameValid("abc"));
    }

    @Test
    void testInvalidUsername() {
        assertFalse(InputValidator.isUsernameValid(""));
        assertFalse(InputValidator.isUsernameValid("ab"));
        assertFalse(InputValidator.isUsernameValid(null));
    }

    @Test
    void testValidPassword() {
        assertTrue(InputValidator.isPasswordValid("secure123"));
        assertTrue(InputValidator.isPasswordValid("123456"));
    }

    @Test
    void testInvalidPassword() {
        assertFalse(InputValidator.isPasswordValid("123"));
        assertFalse(InputValidator.isPasswordValid(""));
        assertFalse(InputValidator.isPasswordValid(null));
    }
}
