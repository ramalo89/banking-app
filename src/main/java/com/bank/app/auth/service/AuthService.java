package com.bank.app.auth.service;

public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String username, String password) {
        return userService.login(username, password);
    }

    public void register(String username, String password) {
        userService.register(username, password);
    }
}
