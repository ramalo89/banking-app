package com.bank.app.auth.repository;

import java.util.Map;

import com.bank.app.auth.model.User;

public interface IUserRepository {
    Map<String, User> loadUsers();
    void saveUsers(Map<String, User> users);
}
