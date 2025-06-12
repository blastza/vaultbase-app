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
```
Update application.properties with your local DB credentials.

### Frontend Setup
```bash
cd frontend
npm install
npm start
```

🧪 Sample User Stories
Implement User Registration Feature
As a new visitor,
I want to register an account,
So that I can access my banking features.

Implement Deposit Feature
As a registered user,
I want to deposit money into my account,
So that I can increase my balance.

## 🗂 Project Structure
```bash
vaultbase/
├── backend/         # Kotlin + Spring Boot backend
├── frontend/        # React frontend
├── docker-compose.yml (optional)
└── README.md
```

### 📄 License
This project is licensed under the MIT License.

