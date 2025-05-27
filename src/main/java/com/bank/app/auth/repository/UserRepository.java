package com.bank.app.auth.repository;

import com.bank.app.auth.model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserRepository implements IUserRepository {
    private final String userFilePath;

    public UserRepository(String userFilePath) {
        this.userFilePath = userFilePath;
    }

    @Override
    public Map<String, User> loadUsers() {
        Map<String, User> users = new HashMap<>();
        File file = new File(userFilePath);
        if (!file.exists()) return users;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    users.put(parts[0], new User(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Failed to load users: " + e.getMessage());
        }

        return users;
    }

    @Override
    public void saveUsers(Map<String, User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + ":" + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠️ Failed to save users: " + e.getMessage());
        }
    }
}
