package com.bank.app.auth.service;

public class AuditService {
    public void logEvent(String event) {
        System.out.println("[AUDIT] " + event);
    }
}
