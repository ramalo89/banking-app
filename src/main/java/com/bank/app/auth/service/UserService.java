package com.bank.app.auth.service;

import com.bank.app.auth.model.User;
import com.bank.app.repository.IUserRepository;

import java.util.Map;

public class UserService {
    private final IUserRepository userRepository;
    private final Map<String, User> users;
    private final AuthValidator validator = new AuthValidator();
    private final AuditService audit = new AuditService();
    private final RateLimiter rateLimiter = new RateLimiter();

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.users = userRepository.loadUsers();
    }

    public boolean login(String username, String password) {
        if (rateLimiter.isBlocked(username)) {
            System.out.println("🚫 Too many failed attempts. Try again later.");
            return false;
        }

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            audit.logEvent("Login success for user: " + username);
            rateLimiter.resetAttempts(username);
            return true;
        } else {
            rateLimiter.recordAttempt(username);
            audit.logEvent("Login failed for user: " + username);
            return false;
        }
    }

    public void register(String username, String password) {
        if (!validator.isUsernameValid(username)) {
            System.out.println("❌ Username must be at least 3 characters long.");
            return;
        }

        if (!validator.isPasswordValid(password)) {
            System.out.println("❌ Password must be at least 6 characters long.");
            return;
        }

        if (validator.isDuplicateUser(username, users)) {
            System.out.println("❌ Username already exists.");
            return;
        }

        users.put(username, new User(username, password));
        userRepository.saveUsers(users);
        audit.logEvent("User registered: " + username);
        System.out.println("✅ Registration successful.");
    }
}
