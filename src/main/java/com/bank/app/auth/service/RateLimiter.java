package com.bank.app.auth.service;

import java.util.HashMap;
import java.util.Map;

/**
 * RateLimiter tracks failed login attempts and blocks users who exceed
 * a defined threshold to mitigate brute-force attacks.
 */
public class RateLimiter {
    private final Map<String, Integer> attempts = new HashMap<>();
    private final int MAX_ATTEMPTS = 5;

    /**
     * Checks whether the given user is currently blocked due to excessive failed attempts.
     *
     * @param username the user to check
     * @return true if user is blocked; false otherwise
     */
    public boolean isBlocked(String username) {
        return attempts.getOrDefault(username, 0) >= MAX_ATTEMPTS;
    }

    /**
     * Records a failed login attempt for a user.
     *
     * @param username the user who failed to log in
     */
    public void recordAttempt(String username) {
        int count = attempts.getOrDefault(username, 0);
        attempts.put(username, count + 1);
    }

    /**
     * Clears recorded attempts for a user upon successful login.
     *
     * @param username the user to reset
     */
    public void resetAttempts(String username) {
        attempts.remove(username);
    }

    /**
     * (Optional) Returns the current attempt count for a user (useful for logging or monitoring).
     *
     * @param username the user to check
     * @return number of failed attempts
     */
    public int getAttemptCount(String username) {
        return attempts.getOrDefault(username, 0);
    }
}
