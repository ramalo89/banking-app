package com.bank.app.auth.service;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private final Map<String, Integer> attempts = new HashMap<>();
    private final int MAX_ATTEMPTS = 5;

    public boolean isBlocked(String username) {
        return attempts.getOrDefault(username, 0) >= MAX_ATTEMPTS;
    }

    public void recordAttempt(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
    }

    public void resetAttempts(String username) {
        attempts.remove(username);
    }
}
