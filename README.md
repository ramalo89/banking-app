# 🏦 Banking App (Java 21)

This is a simple **Java 21 console-based banking app** with file-based user authentication. It supports login and registration, storing user data in `users.txt`, and uses modular classes to separate concerns (service layer, validation, storage).

---

## 🔧 Features

- ✅ Java 21 project with Maven
- 🔐 Login and registration via terminal
- 💾 Persistent user storage using `users.txt`
- 🧱 Modular service structure:
  - `AuthService` for business logic
  - `UserRepository` for file I/O
  - `InputValidator` for field validation
- ❌ Handles invalid usernames and passwords
- 📂 Project structured for future REST API and Docker deployment
- 🧪 Unit test support for AuthService, InputValidator, UserRepository


---

## 🗂️ Project Structure

banking-app/
├── banking-app/
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── bank/
│   │                   └── app/
│   │                       ├── App.java                 # CLI entry point
│   │                       ├── auth/
│   │                       │   ├── AuthService.java     # Login/register logic
│   │                       │   └── User.java            # User model
│   │                       ├── repository/
│   │                       │   └── UserRepository.java  # File storage for users
│   │                       └── validation/
│   │                           └── InputValidator.java  # Validation for inputs
│   ├── pom.xml
│   └── users.txt              # File-based credential store (ignored in Git)
├── .gitignore
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

