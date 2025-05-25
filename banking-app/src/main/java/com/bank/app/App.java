package com.bank.app;

import com.bank.app.auth.AuthService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔐 Welcome to the Banking App");
        System.out.println("Choose an option:");
        System.out.println("[1] Login");
        System.out.println("[2] Register");

        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (authService.login(username, password)) {
                System.out.println("✅ Login successful!");
            } else {
                System.out.println("❌ Login failed. Invalid credentials.");
            }

        } else if (choice.equals("2")) {
            System.out.print("Choose a username: ");
            String newUsername = scanner.nextLine();

            System.out.print("Choose a password: ");
            String newPassword = scanner.nextLine();

            authService.register(newUsername, newPassword);
            System.out.println("✅ Registration successful. Please login next.");
        } else {
            System.out.println("❌ Invalid option. Exiting...");
        }

        scanner.close();
    }
}
