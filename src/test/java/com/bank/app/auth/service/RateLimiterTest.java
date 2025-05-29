package com.bank.app.auth.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RateLimiter class.
 * Ensures proper blocking and reset behavior.
 */
public class RateLimiterTest {

    private RateLimiter rateLimiter;

    @BeforeEach
    void setup() {
        rateLimiter = new RateLimiter();
    }

    @Test
    void testUserNotBlockedInitially() {
        assertFalse(rateLimiter.isBlocked("user1"));
    }

    @Test
    void testRateLimitExceededAfterMaxAttempts() {
        String user = "testuser";

        // Simulate 5 failed attempts
        for (int i = 0; i < 5; i++) {
            rateLimiter.recordAttempt(user);
        }

        assertTrue(rateLimiter.isBlocked(user));
    }

    @Test
    void testResetClearsAttempts() {
        String user = "resetuser";

        rateLimiter.recordAttempt(user);
        rateLimiter.recordAttempt(user);
        assertFalse(rateLimiter.isBlocked(user)); // not yet blocked

        rateLimiter.resetAttempts(user);
        assertFalse(rateLimiter.isBlocked(user));
        assertEquals(0, rateLimiter.getAttemptCount(user));
    }

    @Test
    void testAttemptCountTracking() {
        String user = "attemptUser";
        assertEquals(0, rateLimiter.getAttemptCount(user));

        rateLimiter.recordAttempt(user);
        assertEquals(1, rateLimiter.getAttemptCount(user));

        rateLimiter.recordAttempt(user);
        assertEquals(2, rateLimiter.getAttemptCount(user));
    }
}
