package com.bank.app.repository;

import com.bank.app.auth.User;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    @Test
    public void testSaveAndLoadUsers() {
        String testPath = "banking-app/temp_users_test.txt";

        // ✅ Ensure parent directories exist
        File file = new File(testPath);
        file.getParentFile().mkdirs();

        UserRepository repo = new UserRepository(testPath);

        Map<String, User> usersToSave = new HashMap<>();
        usersToSave.put("junit", new User("junit", "pass123"));

        repo.saveUsers(usersToSave);

        Map<String, User> loaded = repo.loadUsers();
        assertTrue(loaded.containsKey("junit"));
        assertEquals("pass123", loaded.get("junit").getPassword());

        // Clean up test file
        file.delete();
    }
}
