package com.bank.app.auth.service;

import com.bank.app.auth.model.User;

import java.util.Map;

/**
 * AuthValidator contains reusable validation logic for usernames,
 * passwords, and duplicate account detection.
 */
public class AuthValidator {

    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MIN_PASSWORD_LENGTH = 6;

    /**
     * Checks if the provided username meets basic length requirements.
     *
     * @param username the username to validate
     * @return true if valid; false otherwise
     */
    public boolean isUsernameValid(String username) {
        return username != null && username.length() >= MIN_USERNAME_LENGTH;
    }

    /**
     * Checks if the provided password meets basic length requirements.
     *
     * @param password the password to validate
     * @return true if valid; false otherwise
     */
    public boolean isPasswordValid(String password) {
        return password != null && password.length() >= MIN_PASSWORD_LENGTH;
    }

    /**
     * Checks if the username is already present in the user store.
     *
     * @param username the desired username
     * @param users the current user map
     * @return true if the username is already taken; false otherwise
     */
    public boolean isDuplicateUser(String username, Map<String, User> users) {
        return users.containsKey(username);
    }
}
