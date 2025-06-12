# vaultbase-app
A secure base for digital finance.

# VaultBase 🏦

VaultBase is a simple, full-stack banking system designed for learning and showcasing skills in modern backend and frontend development. It supports essential banking operations like user registration, account creation, deposits, withdrawals, and transaction history.

---

## 🚀 Features

- User registration & login
- Create bank accounts (savings/checking)
- Deposit and withdraw funds
- View transaction history
- Check account balance
- Optional admin panel for managing users and accounts

---

## 🛠 Tech Stack

**Frontend**
- React + TypeScript
- CSS Modules or Tailwind CSS

**Backend**
- Kotlin + Spring Boot (Maven)
- PostgreSQL
- JWT-based Authentication

**DevOps / Other**
- Docker (for containerized deployment)
- GitHub Actions (CI/CD - optional)
- Swagger (API docs - optional)

---

## 📦 Getting Started

### Prerequisites
- Java 17+
- Node.js 16+
- PostgreSQL
- Docker (optional, for containerization)

### Backend Setup
```bash
cd backend
./mvnw clean install
./mvnw spring-boot:run
Update application.properties with your local DB credentials.
