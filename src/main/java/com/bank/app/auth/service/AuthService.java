package com.bank.app.auth.service;

/**
 * AuthService acts as a façade to the UserService, exposing only the necessary
 * authentication operations (login and registration) to the CLI (App.java) or
 * any other consumer such as a REST controller in the future.
 */
public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Attempts to log in the user with the provided credentials.
     *
     * @param username the username entered
     * @param password the password entered
     * @return true if login is successful, false otherwise
     */
    public boolean login(String username, String password) {
        return userService.login(username, password);
    }

    /**
     * Attempts to register a new user. Delegates validation and persistence to UserService.
     *
     * @param username the desired username
     * @param password the desired password
     */
    public void register(String username, String password) {
        userService.register(username, password);
    }
}
