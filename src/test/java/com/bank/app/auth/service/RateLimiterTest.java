package com.bank.app.auth.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RateLimiterTest {
    private RateLimiter limiter;

    @BeforeEach
    void setup() {
        limiter = new RateLimiter();
    }

    @Test
    void testRateLimitExceeded() {
        String user = "testuser";
        for (int i = 0; i < 5; i++) limiter.recordAttempt(user);
        assertTrue(limiter.isBlocked(user));
    }

    @Test
    void testResetClearsAttempts() {
        String user = "resetuser";
        limiter.recordAttempt(user);
        limiter.resetAttempts(user);
        assertFalse(limiter.isBlocked(user));
    }
}
