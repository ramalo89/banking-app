package com.bank.app.auth.service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AuditService is responsible for logging important user events such as
 * logins, failed attempts, registrations, and rate-limiting blocks.
 */
public class AuditService {
    private static final Logger logger = Logger.getLogger(AuditService.class.getName());

    /**
     * Logs an event to the audit log.
     *
     * @param event The message describing the event.
     */
    public void logEvent(String event) {
        logger.log(Level.INFO, "[AUDIT] {0}", event);
    }
}
