package com.bank.app.auth;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static final String USER_FILE = "users.txt";
    private Map<String, User> users = new HashMap<>();

    public AuthService() {
        loadUsersFromFile();
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void register(String username, String password) {
        users.put(username, new User(username, password));
        saveUsersToFile();
    }

    private void loadUsersFromFile() {
        File file = new File(USER_FILE);
        if (!file.exists()) return;

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
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + ":" + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠️ Failed to save users: " + e.getMessage());
        }
    }
}
