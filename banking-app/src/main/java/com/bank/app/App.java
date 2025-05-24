package com.bank.app;

import com.bank.app.auth.AuthService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔐 Welcome to the Banking App");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authService.login(username, password)) {
            System.out.println("✅ Login successful!");
        } else {
            System.out.println("❌ Login failed. Invalid credentials.");
        }

        scanner.close();
    }
}
