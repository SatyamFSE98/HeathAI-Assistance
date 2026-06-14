# 🩺 HealthBot - AI Powered Health Query Assistant

## 📌 Overview

HealthBot is a full-stack AI-powered health query assistant built using Spring Boot Microservices, Angular 17, MySQL, MongoDB, Kafka, and Google Gemini AI.

The application allows users to register, login, ask health-related questions, receive AI-generated responses, store chat history, and process chat events asynchronously through Kafka.

This project demonstrates modern enterprise application development using microservices, event-driven architecture, AI integration, and Angular 17 best practices.

---

# 🚀 Features

### User Management

* User Registration
* User Login
* Email-based Authentication
* Route Protection using Angular Guards
* Local Storage Session Management

### AI Health Assistant

* Ask health-related questions
* AI-generated responses using Google Gemini
* Health category identification
* Typing animation while processing

### Chat Management

* Chat History Storage
* View Previous Conversations
* Select Individual Chat Sessions
* Delete Chat History
* Start New Chat Session

### Event Driven Architecture

* Kafka Producer
* Kafka Consumer
* Asynchronous Chat Event Processing
* Notification Service Integration

### Modern Angular Features

* Angular 17 Standalone Components
* Lazy Loading
* Reactive Forms
* OnPush Change Detection
* RxJS switchMap
* RxJS concatMap
* Async Pipe
* Angular 17 @if
* Angular 17 @for
* Route Guards
* HTTP Interceptors

---

# 🏗️ Architecture

```text
Angular 17 Frontend
        |
        |
        v
+----------------+
| user-service   |
+----------------+
        |
        v
      MySQL

Angular
   |
   v
+----------------+
| chat-service   |
+----------------+
        |
        v
     MongoDB

        |
        | Kafka Producer
        v

+----------------------+
| chat-query-events    |
+----------------------+

        |
        | Kafka Consumer
        v

+----------------------+
| notification-service |
+----------------------+
```

---

# 🛠️ Tech Stack

## Frontend

* Angular 17
* TypeScript
* SCSS
* RxJS
* Angular Router
* Reactive Forms

## Backend

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Spring Data MongoDB
* Spring Kafka

## Database

* MySQL
* MongoDB

## Messaging

* Apache Kafka
* Kafka UI

## AI

* Google Gemini API

## Tools

* Maven
* Git
* GitHub
* Postman
* Docker

---

# 📂 Microservices

## user-service

Handles:

* User Registration
* User Login
* User Profile Management

Database:

```text
MySQL
```

Endpoints:

```http
POST /api/users/register
POST /api/users/login
GET  /api/users/{id}
```

---

## chat-service

Handles:

* Ask Health Questions
* Gemini AI Integration
* Chat History Management

Database:

```text
MongoDB
```

Endpoints:

```http
POST   /api/chats/ask
GET    /api/chats/user/{userId}
DELETE /api/chats/user/{userId}
```

---

## notification-service

Handles:

* Kafka Event Consumption
* Chat Event Logging
* Future Email/SMS Notifications

Kafka Topic:

```text
chat-query-events
```

---

# 🗄️ Database Design

## MySQL

### users

| Column     | Type      |
| ---------- | --------- |
| id         | BIGINT    |
| full_name  | VARCHAR   |
| email      | VARCHAR   |
| password   | VARCHAR   |
| role       | VARCHAR   |
| created_at | TIMESTAMP |

---

## MongoDB

### chat_messages

```json
{
  "id": "6658f7ab",
  "userId": 1,
  "question": "I have fever",
  "answer": "Drink plenty of fluids and rest.",
  "category": "FEVER",
  "createdAt": "2026-06-14T10:30:00"
}
```

---

# 🤖 Gemini AI Integration

HealthBot integrates with Google Gemini API to generate dynamic health guidance.

Flow:

```text
User Question
      |
      v
Gemini API
      |
      v
AI Generated Answer
      |
      v
MongoDB Storage
      |
      v
Kafka Event
```

---

# 📡 Kafka Flow

```text
User submits query
      |
      v
chat-service
      |
      v
Kafka Producer
      |
      v
chat-query-events
      |
      v
notification-service
```

Benefits:

* Loose Coupling
* Scalability
* Event Driven Design
* Async Processing

---

# 🔥 Angular Concepts Used

### Standalone Components

```text
Login
Register
Chat
```

### Routing

```text
/login
/register
/chat
```

### Route Guards

Protect chat page from unauthorized access.

### RxJS

switchMap:

```text
Load latest chat history
```

concatMap:

```text
Send Message
→ Refresh Chat History
```

### OnPush Change Detection

Improves performance by reducing unnecessary UI updates.

### Angular 17 Control Flow

```html
@if

@for
```

---

# 📸 Application Screens

### Login Page

* Modern Glassmorphism Design
* Email Login
* Future Google Login Support

### Register Page

* User Registration
* Form Validation

### Chat Page

* ChatGPT-style Layout
* Sidebar Chat History
* New Chat
* Delete History
* Typing Animation

---

# 🚀 Running the Project

## Start Infrastructure

```bash
docker compose up -d
```

Services:

```text
Kafka
Kafka UI
MongoDB
MySQL
```

---

## Start user-service

```bash
mvn spring-boot:run
```

Runs on:

```text
http://localhost:8081
```

---

## Start chat-service

```bash
mvn spring-boot:run
```

Runs on:

```text
http://localhost:8082
```

---

## Start notification-service

```bash
mvn spring-boot:run
```

Runs on:

```text
http://localhost:8083
```

---

## Start Angular

```bash
ng serve
```

Runs on:

```text
http://localhost:4200
```

---

# 🎯 Future Enhancements

* Google OAuth Login
* JWT Authentication
* Spring Security
* API Gateway
* Service Discovery
* Docker Compose for Entire Platform
* Kubernetes Deployment
* Email Notifications
* Chat Session Management
* Health Report Generation

---

# 📚 Learning Outcomes

This project demonstrates:

* Microservice Architecture
* Event Driven Design
* Kafka Integration
* MongoDB Usage
* MySQL Integration
* AI Integration
* Angular 17 Features
* Reactive Programming
* REST API Development
* Full Stack Development

---

# 👨‍💻 Author

**Satyam Trivedi**

Java Full Stack Developer

Tech Stack:

* Java
* Spring Boot
* Angular
* Kafka
* MySQL
* MongoDB
* AWS
* Docker
* Kubernetes
