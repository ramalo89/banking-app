package com.bank.app.auth.repository;

import com.bank.app.auth.model.User;
import java.util.Map;

public interface IUserRepository {
    Map<String, User> loadUsers();
    void saveUsers(Map<String, User> users);
}
