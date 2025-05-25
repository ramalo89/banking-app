package com.bank.app.auth;

import com.bank.app.repository.UserRepository;

import java.util.Map;

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
        users.put(username, new User(username, password));
        userRepository.saveUsers(users);
    }
}
