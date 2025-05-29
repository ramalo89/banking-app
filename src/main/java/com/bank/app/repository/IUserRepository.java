package com.bank.app.repository;

import com.bank.app.auth.model.User;

import java.util.Map;

/**
 * IUserRepository defines the contract for any user persistence mechanism.
 * Implementations may use flat files, databases, memory, or external services.
 */
public interface IUserRepository {

    /**
     * Loads all users from the underlying data source.
     *
     * @return a map of usernames to User objects
     */
    Map<String, User> loadUsers();

    /**
     * Persists all users to the underlying data source.
     *
     * @param users the map of users to save
     */
    void saveUsers(Map<String, User> users);
}
