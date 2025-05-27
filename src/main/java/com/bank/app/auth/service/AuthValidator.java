package com.bank.app.auth.service;

import java.util.Map;

import com.bank.app.auth.model.User;

public class AuthValidator {

    public boolean isUsernameValid(String username) {
        return username != null && username.length() >= 3;
    }

    public boolean isPasswordValid(String password) {
        return password != null && password.length() >= 6;
    }

    public boolean isDuplicateUser(String username, Map<String, User> users) {
        return users.containsKey(username);
    }
}
