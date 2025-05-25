# 🏦 Banking App (Java 21, Maven)

A clean, modular Java 21 console-based banking application that supports **user login and registration** with persistent storage using `users.txt`. The application follows **best practices** in structure and testing, designed to grow into a scalable architecture.

---

## ✅ Features

- 🔐 User login and registration
- 💾 File-based persistence (`users.txt`)
- 🧱 Modular architecture (Service, Repository, Validation)
- 🧪 Unit testing with JUnit 5 (Maven Surefire)
- 🚫 Sensitive files like `users.txt` and build artifacts ignored via `.gitignore`
- 🧼 Clean console UI with validation feedback
- ☕ Built using **Java 21** and **Maven**

---

## 🗂️ Project Structure

banking-app/
├── src/
│ ├── main/
│ │ └── java/com/bank/app/
│ │ ├── App.java # CLI entry point
│ │ ├── auth/
│ │ │ ├── AuthService.java # Business logic
│ │ │ └── User.java # Data model
│ │ ├── repository/
│ │ │ └── UserRepository.java # File I/O (users.txt)
│ │ └── validation/
│ │ └── InputValidator.java # Username/password validation
│ └── test/
│ └── java/com/bank/app/
│ ├── AppTest.java
│ ├── auth/AuthServiceTest.java
│ ├── repository/UserRepositoryTest.java
│ └── validation/InputValidatorTest.java
├── pom.xml # Maven config (Java 21, JUnit 5, Surefire)
├── .gitignore # Ignores users.txt, /target/, system files
├── users.txt # User data (ignored in Git)
└── README.md

---

## 🔧 Architecture Overview

This app is now modularized for maintainability:

- **App.java** – CLI entry point that handles user interaction and flows
- **AuthService.java** – Core business logic for login and registration
- **UserRepository.java** – File-based persistence for `users.txt`
- **User.java** – Represents a user with username and password
- **InputValidator.java** – Validates user input (username/password rules)

---

### 🛠️ Future Enhancements
- `UserService.java` – (Optional) Business abstraction for cleaner orchestration
- Add JUnit 5 tests for validator, auth logic, and file access
- Containerize with Docker (for EC2 or EKS deployment)

---

## 🧪 Testing

Run tests using:

```bash
mvn test

Test coverage includes:
✅ InputValidatorTest – validation logic
✅ AuthServiceTest – registration/login behavior
✅ UserRepositoryTest – file I/O for users

---

# Compile - Make sure users.txt exists under banking-app/ folder, or it will be created at runtime.
mvn clean compile

# Run manually
java -cp target/classes com.bank.app.App