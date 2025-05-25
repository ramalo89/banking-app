package com.bank.app.repository;

import com.bank.app.auth.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    @Test
    public void testSaveAndLoadUsers(@TempDir File tempDir) {
        // ✅ Use JUnit 5 temp directory (auto cleaned up)
        File tempFile = new File(tempDir, "users_test.txt");
        UserRepository repo = new UserRepository(tempFile.getAbsolutePath());

        Map<String, User> usersToSave = new HashMap<>();
        usersToSave.put("junit", new User("junit", "pass123"));

        // ✅ Save and load users
        repo.saveUsers(usersToSave);
        Map<String, User> loaded = repo.loadUsers();

        // ✅ Assertions
        assertTrue(loaded.containsKey("junit"));
        assertEquals("pass123", loaded.get("junit").getPassword());
    }
}
