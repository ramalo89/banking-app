# 🏦 Banking App (Java 21)

This is a **Java 21 CLI banking app** built with **Maven**, designed for modularity and testability. It features login and registration backed by file-based user storage and unit-tested service layers.

---

## 🚀 Features

- ✅ Java 21 (with Maven)
- 🔐 User login and registration
- 💾 File-based persistent storage (`users.txt`)
- 🧱 Modular architecture (auth, repository, validation)
- 🧪 JUnit 5 test suite
- 📁 Configurable file path for user data (test/prod friendly)
- 🚧 Future-ready for RESTful API expansion

---

## 🧠 Architecture Overview

| Component         | Responsibility                                |
|------------------|------------------------------------------------|
| `App.java`        | CLI entry point                               |
| `AuthService.java`| Login/registration logic                      |
| `User.java`       | User model                                    |
| `UserRepository.java` | Read/write logic for `users.txt`         |
| `InputValidator.java` | Ensures valid usernames/passwords         |

---

## 🧪 Tests

All core modules are unit-tested using **JUnit 5**.

| Test Class                      | Purpose                                   |
|--------------------------------|-------------------------------------------|
| `InputValidatorTest.java`      | Validates input rules                     |
| `AuthServiceTest.java`         | Auth logic (login, register, edge cases)  |
| `UserRepositoryTest.java`      | File I/O (save/load user data)            |
| `AppTest.java` *(placeholder)* | CLI entry point stub                      |

---

## 📁 Project Structure

```bash
banking-app/
├── src/
│   ├── main/
│   │   └── java/com/bank/app/
│   │       ├── App.java
│   │       ├── auth/
│   │       │   ├── AuthService.java
│   │       │   └── User.java
│   │       ├── repository/
│   │       │   └── UserRepository.java
│   │       └── validation/
│   │           └── InputValidator.java
│   └── test/
│       └── java/com/bank/app/
│           ├── AppTest.java
│           ├── auth/AuthServiceTest.java
│           ├── repository/UserRepositoryTest.java
│           └── validation/InputValidatorTest.java
├── users.txt *(gitignored)*
├── pom.xml
└── README.md
```

## 🛠 Build & Run

# Compile
mvn clean install

# Run
java -cp target/classes com.bank.app.App
