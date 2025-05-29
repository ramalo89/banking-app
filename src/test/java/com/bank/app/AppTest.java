package com.bank.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Basic test to ensure App class loads and compiles.
 */
public class AppTest {
    @Test
    void testAppClassLoads() {
        App app = new App(); // Force class load (even though App has no fields)
        assertNotNull(app);  // This line will always pass
    }
}
