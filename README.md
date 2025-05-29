# 🏦 Banking App CLI
[![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk)](https://openjdk.org/projects/jdk/21/)
[![Build](https://img.shields.io/badge/build-passing-brightgreen?logo=apachemaven)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)
![Tests](https://img.shields.io/badge/tests-100%25_passed-brightgreen)
---
## 🔰 Overview
This is a **Java 21 CLI-based banking application**, built using **Maven** with a focus on clean architecture, decoupled service layers, and strong test coverage. It simulates a secure user login and registration flow with file-based persistence and is structured for future conversion into microservices or REST APIs.

---
## 🚀 Features
- ✅ Java 21 compatibility
- 🧱 Modular architecture with SOLID principles
- 🔐 Secure login with rate-limiting
- 📝 File-based persistence (`users.txt`)
- 🛡️ Duplicate username protection
- 🧪 JUnit 5 + Mockito test suite
- 📦 Easily extensible for Spring Boot & REST
- 🧠 Designed for observability/logging
- ⚙️ Configurable data source path

---
## 🧠 Architecture

```
[👤 User]
    |
+------------------+
|   App.java (UI)  |   ← CLI user interaction
+------------------+
    |
 calls
    ↓
+------------------------+
|   AuthService.java     |   ← Delegates to UserService
+------------------------+
    |
 calls
    ↓
+--------------------+
| UserService.java   |   ← Business logic, rate limiting
+--------------------+
    |
 uses
 ┌─────────────┬─────────────┬──────────────┐
 ↓             ↓             ↓              ↓
UserRepository  AuthValidator RateLimiter   AuditService
   (I/O)         (validation)  (throttling)  (logging)
```

---

## 📁 Project Structure

```
banking-app/
├── src/
│   ├── main/
│   │   └── java/com/bank/app/
│   │       ├── App.java
│   │       ├── auth/
│   │       │   ├── model/User.java
│   │       │   └── service/
│   │       │       ├── AuthService.java
│   │       │       ├── UserService.java
│   │       │       ├── AuditService.java
│   │       │       ├── RateLimiter.java
│   │       │       └── AuthValidator.java
│   │       ├── repository/
│   │       │   ├── IUserRepository.java
│   │       │   └── UserRepository.java
│   │       └── validation/
│   │           └── InputValidator.java
│   └── test/
│       └── java/com/bank/app/
│           ├── AppTest.java
│           ├── auth/service/
│           │   ├── AuthServiceTest.java
│           │   ├── UserServiceTest.java
│           │   ├── AuditServiceTest.java
│           │   ├── RateLimiterTest.java
│           │   └── AuthValidatorTest.java
│           ├── repository/
│           │   └── UserRepositoryTest.java
│           └── validation/
│               └── InputValidatorTest.java
├── users.txt                # (ignored in .gitignore)
├── pom.xml
└── README.md
```

---

## 🧪 Test Coverage
| Test Class           | Coverage                           |
| -------------------- | ---------------------------------- |
| `AuthServiceTest`    | Delegation logic to UserService    |
| `UserServiceTest`    | Login, registration, rate limiting |
| `UserRepositoryTest` | File I/O read/write validation     |
| `AuditServiceTest`   | Logger output test                 |
| `RateLimiterTest`    | Throttling logic verification      |
| `AuthValidatorTest`  | Username/password rules            |
| `InputValidatorTest` | Input constraints                  |
| `AppTest`            | CLI entry-point smoke test         |

🔬 Total: 100% of core logic covered with unit tests.

---
## 🛠 Build & Run

⬇️ Clone the repo

git clone https://github.com/yourusername/banking-app.git
cd banking-app

🔨 Build the project

mvn clean install

▶️ Run the CLI app

java -cp target/classes com.bank.app.App

---

## 🔨 Compile

mvn clean install

---

## ▶️ Run CLI

java -cp target/classes com.bank.app.App

---

## 📌 Notes

- users.txt is auto-managed and ignored in version control.

- Each service is decoupled to support microservice extraction and observability.

- You can easily add Spring Boot REST wrappers around each service.


---

📄 License
This project is licensed under the MIT License.