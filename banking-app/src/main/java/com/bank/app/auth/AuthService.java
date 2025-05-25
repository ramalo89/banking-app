package com.bank.app.auth;

import com.bank.app.repository.UserRepository;

import java.util.Map;
import com.bank.app.validation.InputValidator;

public class AuthService {
    private final UserRepository userRepository;
    private final Map<String, User> users;

    public AuthService() {
        this.userRepository = new UserRepository("banking-app/users.txt");
        this.users = userRepository.loadUsers();
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void register(String username, String password) {
        if (!InputValidator.isUsernameValid(username)) {
            System.out.println("❌ Username must be at least 3 characters long.");
            return;
        }
    
        if (!InputValidator.isPasswordValid(password)) {
            System.out.println("❌ Password must be at least 6 characters long.");
            return;
        }
    
        users.put(username, new User(username, password));
        userRepository.saveUsers(users);
        System.out.println("✅ Registration successful. Please login next.");
    }
}
