package com.bank.app.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void testValidUsername() {
        assertTrue(InputValidator.isUsernameValid("user123"));
    }

    @Test
    void testInvalidUsername() {
        assertFalse(InputValidator.isUsernameValid(""));
        assertFalse(InputValidator.isUsernameValid("ab"));
    }

    @Test
    void testValidPassword() {
        assertTrue(InputValidator.isPasswordValid("secure123"));
    }

    @Test
    void testInvalidPassword() {
        assertFalse(InputValidator.isPasswordValid("123"));
        assertFalse(InputValidator.isPasswordValid(null));
    }
}
