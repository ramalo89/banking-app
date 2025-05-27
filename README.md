# 🏦 Banking App

[![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk)](https://openjdk.org/projects/jdk/21/)
[![Build](https://img.shields.io/badge/build-passing-brightgreen?logo=apachemaven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)
![Tests](https://img.shields.io/badge/tests-13_passed-brightgreen)

---

## 🔰 Overview

This is a **Java 21 modular CLI banking app** built with **Maven**, focusing on **clean architecture**, **unit testing**, and **decoupled services** for future microservice transformation. Core features include login, registration, and basic validation with extensibility for rate-limiting and audit logging.

---

## 🚀 Features

- ✅ Java 21 with Maven
- 🔐 Secure user login and registration
- 🧱 Fully modular architecture
- 🗂️ Decoupled services: Auth, Validation, Repository, Audit, RateLimiter
- 💾 File-based persistent storage (`users.txt`)
- 🔍 Designed for observability & microservice readiness
- 🧪 JUnit 5 test suite with edge-case coverage
- ⚙️ Configurable file path for environment flexibility (dev/test/prod)
- 🚧 Ready for REST API & database integrations

---

## 🧠 Architecture Overview

| Module                       | Responsibility                                   |
|------------------------------|--------------------------------------------------|
| `App.java`                   | CLI interface & user flow                        |
| `AuthService.java`           | Orchestrates auth operations                     |
| `UserService.java`           | Interacts with repository layer                  |
| `UserRepository.java`        | Handles I/O operations with `users.txt`          |
| `InputValidator.java`        | Validates usernames and passwords               |
| `AuthValidator.java`         | Auth-specific validation (user exists, match)    |
| `AuditService.java`          | Logs auth events (e.g., login success/failure)   |
| `RateLimiter.java`           | Throttles repeated login attempts                |
| `User.java`                  | POJO for user data                               |

---

## 📁 Project Structure

```bash
banking-app/
├── src/
│   ├── main/
│   │   └── java/com/bank/app/
│   │       ├── App.java
│   │       ├── auth/
│   │       │   ├── services/
│   │       │   │   ├── AuthService.java
│   │       │   │   ├── UserService.java
│   │       │   │   ├── AuditService.java
│   │       │   │   ├── RateLimiter.java
│   │       │   │   └── AuthValidator.java
│   │       │   └── model/
│   │       │       └── User.java
│   │       ├── repository/
│   │       │   ├── UserRepository.java
│   │       │   └── UserRepositoryInterface.java
│   │       └── validation/
│   │           └── InputValidator.java
│   └── test/
│       └── java/com/bank/app/
│           ├── AppTest.java *(placeholder)*
│           ├── auth/
│           │   └── services/
│           │       ├── AuthServiceTest.java
│           │       ├── UserServiceTest.java
│           │       ├── AuditServiceTest.java
│           │       └── RateLimiterTest.java
│           ├── repository/
│           │   └── UserRepositoryTest.java
│           └── validation/
│               └── InputValidatorTest.java
├── users.txt *(gitignored)*
├── pom.xml
└── README.md
```

---

🧪 Test Coverage
All core modules are covered with JUnit 5 tests to ensure robustness and maintainability.

Test Class	Coverage Highlights
AuthServiceTest	Login, registration, edge cases
UserServiceTest	User retrieval and delegation logic
UserRepositoryTest	File I/O for user persistence
InputValidatorTest	Username/password validation rules
AuditServiceTest	Logging of events
RateLimiterTest	Brute-force prevention logic
AppTest (placeholder)	CLI interaction stub

AuthValidator is currently untested — future enhancement planned.

---

🛠 Build & Run

# 🔨 Compile
mvn clean install

# ▶️ Run CLI
java -cp target/classes com.bank.app.App

---

```
         [👤 User]
             |
     +------------------+
     |   App.java (UI)  |   ← Handles user input/output
     +------------------+
             |
         orchestrates flow
             ↓
   +------------------------+
   |   AuthService.java     |   ← Coordinates auth flow
   +------------------------+
             |
  ┌──────────┴────────────┬──────────────┐
  ↓                       ↓              ↓
+-------------------+  +------------------------+  +----------------------+
| UserService.java  |  |   AuthValidator.java   |  |   RateLimiter.java   |
| - Loads users     |  | - Validates auth rules |  | - Blocks brute force |
+-------------------+  +------------------------+  +----------------------+
             |
         delegates I/O
             ↓
+------------------------------+
|   UserRepository.java        |   ← Loads/Saves users (File/Memory)
+------------------------------+
             ↑
      reads/writes data
             ↓
+-------------------+
|   users.txt file  |   ← Gitignored flat file storage
+-------------------+

        (side channel)
             ↓
     +----------------------+
     |  AuditService.java   |   ← Logs login/register events
     +----------------------+
```

---

📌 Notes
users.txt is auto-managed and ignored in version control.

Each service is decoupled to support microservice extraction and observability.

You can easily add Spring Boot REST wrappers around each service.


📄 License
This project is licensed under the MIT License.