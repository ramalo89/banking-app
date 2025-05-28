package com.bank.app;

import com.bank.app.auth.service.AuthService;
import com.bank.app.auth.service.UserService;
import com.bank.app.repository.UserRepository;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserService(new UserRepository("users.txt"));
        AuthService authService = new AuthService(userService);
        Scanner scanner = new Scanner(System.in);

        System.out.println("\uD83D\uDD10 Welcome to the Banking App");
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
                System.out.println("❌ Login failed. Invalid credentials or too many attempts.");
            }
        } else if (choice.equals("2")) {
            System.out.print("Choose a username: ");
            String newUsername = scanner.nextLine();

            System.out.print("Choose a password: ");
            String newPassword = scanner.nextLine();

            authService.register(newUsername, newPassword);
        } else {
            System.out.println("❌ Invalid option. Exiting...");
        }

        scanner.close();
    }
}
