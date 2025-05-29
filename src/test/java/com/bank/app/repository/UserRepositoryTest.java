package com.bank.app.repository;

import com.bank.app.auth.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for UserRepository.
 * Uses @TempDir to isolate file storage in test.
 */
public class UserRepositoryTest {

    @Test
    void testSaveAndLoadUsers(@TempDir File tempDir) {
        // Setup temp file for user data
        File tempFile = new File(tempDir, "users_test.txt");
        UserRepository repo = new UserRepository(tempFile.getAbsolutePath());

        // Prepare mock user data
        Map<String, User> usersToSave = new HashMap<>();
        usersToSave.put("junit", new User("junit", "pass123"));
        usersToSave.put("alice", new User("alice", "secure456"));

        // Save users
        repo.saveUsers(usersToSave);

        // Load users back
        Map<String, User> loadedUsers = repo.loadUsers();

        // Assertions
        assertEquals(2, loadedUsers.size());
        assertTrue(loadedUsers.containsKey("junit"));
        assertTrue(loadedUsers.containsKey("alice"));
        assertEquals("pass123", loadedUsers.get("junit").getPassword());
        assertEquals("secure456", loadedUsers.get("alice").getPassword());
    }

    @Test
    void testLoadUsersWhenFileDoesNotExist(@TempDir File tempDir) {
        File nonExistentFile = new File(tempDir, "missing.txt");
        UserRepository repo = new UserRepository(nonExistentFile.getAbsolutePath());

        Map<String, User> users = repo.loadUsers();

        assertNotNull(users);
        assertTrue(users.isEmpty());
    }

    @Test
    void testSaveUsersOverwritesExistingContent(@TempDir File tempDir) {
        File tempFile = new File(tempDir, "overwrite_test.txt");
        UserRepository repo = new UserRepository(tempFile.getAbsolutePath());

        // Save initial user
        Map<String, User> usersV1 = new HashMap<>();
        usersV1.put("olduser", new User("olduser", "oldpass"));
        repo.saveUsers(usersV1);

        // Overwrite with new user
        Map<String, User> usersV2 = new HashMap<>();
        usersV2.put("newuser", new User("newuser", "newpass"));
        repo.saveUsers(usersV2);

        Map<String, User> loaded = repo.loadUsers();

        assertEquals(1, loaded.size());
        assertTrue(loaded.containsKey("newuser"));
        assertFalse(loaded.containsKey("olduser"));
    }
}
