package com.bank.app.auth.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Temporarily disabled test for AuditService logger.
 * Will re-enable when migrating to REST with proper log testing tools.
 */
public class AuditServiceTest {

    @Test
    @Disabled("Logger output assertion skipped until REST transition")
    void testLogEventOutputsMessage() {
        // Test intentionally disabled to avoid fragile logger output capture
    }
}
