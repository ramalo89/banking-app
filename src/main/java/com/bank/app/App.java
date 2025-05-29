package com.bank.app;

import com.bank.app.auth.service.AuthService;
import com.bank.app.auth.service.UserService;
import com.bank.app.repository.UserRepository;

import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserService userService = new UserService(new UserRepository("users.txt"));
        AuthService authService = new AuthService(userService);

        System.out.println("🔐 Welcome to the CLI Banking App");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> handleLogin(authService);
                case "2" -> handleRegister(authService);
                case "3" -> {
                    System.out.println("👋 Goodbye!");
                    running = false;
                }
                default -> System.out.println("❌ Invalid option. Please try again.");
            }

            System.out.println(); // spacing
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("========= MENU =========");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        System.out.println("[3] Exit");
        System.out.print("Enter choice: ");
    }

    private static void handleLogin(AuthService authService) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        boolean success = authService.login(username, password);
        if (success) {
            System.out.println("✅ Login successful!");
            // In a real app, you'd now show the user's dashboard here.
        } else {
            System.out.println("❌ Login failed. Invalid credentials or too many attempts.");
        }
    }

    private static void handleRegister(AuthService authService) {
        System.out.print("Choose a username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Choose a password: ");
        String password = scanner.nextLine().trim();

        authService.register(username, password);
    }
}
