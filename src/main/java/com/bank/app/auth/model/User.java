package com.bank.app.auth.model;

/**
 * Represents a user with basic authentication credentials.
 * This model is currently used for in-memory and file-based storage.
 */
public class User {
    private final String username;
    private final String password;

    /**
     * Constructs a User object with the given username and password.
     *
     * @param username the user's username
     * @param password the user's password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User other)) return false;
        return username.equals(other.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
