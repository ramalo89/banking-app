package com.bank.app.auth.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for AuditService that verifies log output.
 */
public class AuditServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private AuditService auditService;

    @BeforeEach
    void setup() {
        // Redirect system output to capture logs
        System.setOut(new PrintStream(outContent));

        // Enable root logger console output
        Logger logger = Logger.getLogger(AuditService.class.getName());
        logger.setUseParentHandlers(false); // disable default handlers
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        logger.addHandler(handler);
        logger.setLevel(Level.INFO);

        auditService = new AuditService();
    }

    @Test
    void testLogEventOutputsMessage() {
        String message = "User login successful";
        auditService.logEvent(message);

        String output = outContent.toString();
        assertTrue(output.contains("User login successful"));
        assertTrue(output.contains("[AUDIT]"));
    }
}
