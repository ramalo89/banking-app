# 🏦 Banking App (Java 21)

This is a simple **Java 21 console-based banking app** with file-based user authentication. It supports login and registration, storing user data in `users.txt`, and uses modular classes to separate concerns (service layer, validation, storage).

---

## 🔧 Features

- ✅ Java 21 project with Maven
- 🔐 Login and registration functionality
- 💾 Persistent user storage (`users.txt`)
- 🧱 Service-layer structure (coming next)
- ✅ Input validation (coming next)
- 🧪 Unit test support (coming next)
- 🖥️ Designed for CLI & future REST API conversion

---

## 🗂️ Project Structure

banking-app/ 
├── banking-app/ 
│ ├── src/ 
│ │ └── main/ 
│ │ └── java/ 
│ │ └── com/ 
│ │ └── bank/ 
│ │ └── app/ 
│ │ ├── App.java # CLI entry point 
│ │ ├── auth/ 
│ │ │ ├── AuthService.java # Business logic for login/register 
│ │ │ └── User.java # User model 
│ │ ├── repository/ 
│ │ │ └── UserRepository.java # File I/O for users.txt 
│ │ └── validation/ 
│ │ └── InputValidator.java # (Coming next) 
│ ├── pom.xml 
│ └── users.txt # Runtime user data (ignored in Git) 

---

## 🔧 Architecture Overview

This app is now modularized for maintainability:

- **App.java** – CLI entry point that handles user input
- **AuthService.java** – Business logic for login and registration
- **UserRepository.java** – Handles reading/writing users from `users.txt`
- **User.java** – Data model for user credentials

---

### 🛠️ Upcoming Modules
- `InputValidator.java` – Will handle username/password validation logic
