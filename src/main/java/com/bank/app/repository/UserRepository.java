package com.bank.app.repository;

import com.bank.app.auth.model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * UserRepository provides a file-based implementation of the IUserRepository
 * interface. It stores user data in a flat file using username:password format.
 */
public class UserRepository implements IUserRepository {
    private final String userFilePath;

    /**
     * Constructs the repository with a configurable file path.
     *
     * @param userFilePath path to the user data file
     */
    public UserRepository(String userFilePath) {
        this.userFilePath = userFilePath;
    }

    /**
     * Loads users from the file. Each line should follow the format: username:password
     *
     * @return a map of username to User objects
     */
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
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    users.put(username, new User(username, password));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Failed to load users: " + e.getMessage());
        }

        return users;
    }

    /**
     * Saves the given map of users to the file, overwriting existing contents.
     *
     * @param users a map of username to User objects
     */
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
