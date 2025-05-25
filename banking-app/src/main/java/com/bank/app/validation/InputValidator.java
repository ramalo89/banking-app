package com.bank.app.validation;

public class InputValidator {

    public static boolean isUsernameValid(String username) {
        return username != null && username.length() >= 3;
    }

    public static boolean isPasswordValid(String password) {
        return password != null && password.length() >= 6;
    }
}
