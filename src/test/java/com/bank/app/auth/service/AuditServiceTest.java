package com.bank.app.auth.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuditServiceTest {
    private AuditService auditService;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setup() {
        auditService = new AuditService();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testLogEventOutput() {
        auditService.logEvent("Testing Audit");
        assertTrue(outContent.toString().contains("[AUDIT] Testing Audit"));
    }
}