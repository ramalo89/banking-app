package com.bank.app.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, User> users = new HashMap<>();

    public AuthService() {
        // Seed a default user
        users.put("admin", new User("admin", "admin123"));
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void register(String username, String password) {
        users.put(username, new User(username, password));
    }
}
