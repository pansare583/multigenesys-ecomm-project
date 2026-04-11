<<<<<<< HEAD
# 🛒 E-Commerce Backend — Production-Ready Spring Boot REST API

A professional, secure, and scalable e-commerce backend built with **Spring Boot 3**, **Spring Security (JWT)**, **Spring Data JPA (MySQL)**, and **Stripe Payment Integration**.

---

## ✨ Features

| Feature | Description |
|---|---|
| 🔐 **JWT Authentication** | Register / Login with BCrypt-encrypted passwords and stateless JWT tokens |
| 👥 **Role-Based Access** | `ROLE_USER` and `ROLE_ADMIN` authorization on every endpoint |
| 📦 **Product Management** | Full CRUD for products (public read, admin-only write) |
| 🛒 **Cart Management** | Personal cart per user — add, update, remove items |
| 📋 **Order Management** | Checkout from cart, view order history, update order status |
| 💳 **Stripe Payments** | Create Stripe PaymentIntents, get `clientSecret` for frontend integration |
| 📄 **Swagger UI** | Interactive API docs at `/swagger-ui/index.html` |
| 🧪 **Unit Tests** | JUnit 5 & Mockito tests for Auth, Product, Cart, and Order services |
| 🔄 **Auto Data Seeding** | Sample products and admin/user accounts loaded on startup |

---

## 🛠 Tech Stack

- **Java 17** · **Spring Boot 3.2.x** · **Spring Security** · **Spring Data JPA**
- **MySQL** · **Lombok** · **MapStruct** · **JJWT**
- **Stripe Java SDK** · **SpringDoc OpenAPI** · **JUnit 5 & Mockito**

---

## 🏗 Project Structure

```text
com.ecommerce
├── config         → SecurityConfig, Swagger config
├── security       → JwtUtils, AuthTokenFilter, AuthEntryPointJwt
├── controller     → AuthController, ProductController, CartController, OrderController
├── service
│   └── impl       → AuthServiceImpl, ProductServiceImpl, CartServiceImpl, OrderServiceImpl, PaymentServiceImpl
├── repository     → UserRepository, ProductRepository, CartItemRepository, OrderRepository
├── entity         → User, Product, CartItem, Order (with OrderStatus enum)
├── dto            → LoginRequest, SignupRequest, JwtResponse, ProductDTO, CartDTO, OrderDTO
├── mapper         → ProductMapper, CartItemMapper, OrderMapper (MapStruct)
├── exception      → GlobalExceptionHandler, ResourceNotFoundException, BadRequestException
└── util           → DataLoader
=======
# E-Commerce Backend Project

This is my e-commerce backend project made using Spring Boot. It provides APIs for user login, product management, cart handling, order processing, and Stripe payment integration.

The project is built with Spring Boot 3, Spring Security with JWT, MySQL, and Stripe.

---

# Features

* User Registration and Login
* JWT Authentication
* Role-based Authorization (`USER` and `ADMIN`)
* Product CRUD Operations
* Cart Management
* Order Creation and Order History
* Stripe Payment Integration
* Swagger API Documentation
* Unit Testing using JUnit and Mockito
* Sample Data Loaded Automatically

---

# Technologies Used

* Java 17
* Spring Boot 3.2.x
* Spring Security
* Spring Data JPA
* MySQL
* Lombok
* MapStruct
* JWT (JJWT)
* Stripe Java SDK
* Swagger / SpringDoc OpenAPI
* JUnit 5
* Mockito

---

# Project Structure

```text
src/main/java/com/ecommerce
│
├── config
│   ├── SecurityConfig
│   └── SwaggerConfig
│
├── security
│   ├── JwtUtils
│   ├── AuthTokenFilter
│   └── AuthEntryPointJwt
│
├── controller
│   ├── AuthController
│   ├── ProductController
│   ├── CartController
│   └── OrderController
│
├── service
│   └── impl
│       ├── AuthServiceImpl
│       ├── ProductServiceImpl
│       ├── CartServiceImpl
│       ├── OrderServiceImpl
│       └── PaymentServiceImpl
│
├── repository
│   ├── UserRepository
│   ├── ProductRepository
│   ├── CartItemRepository
│   └── OrderRepository
│
├── entity
│   ├── User
│   ├── Product
│   ├── CartItem
│   ├── Order
│   └── OrderStatus
│
├── dto
├── mapper
├── exception
└── util
>>>>>>> b87e2a182a7b2d94b8648084958a594291348a53
```

---

<<<<<<< HEAD
## 🚦 Getting Started

### Prerequisites
- Java 17+
- MySQL Server
- Maven

### Setup

**1. Clone the repository**
```bash
git clone https://github.com/exelynt-learning-platform/second-round-assignm-final-13132-priti.git
cd second-round-assignm-final-13132-priti
git checkout develop-the-backend-for-an-e-commerce-system-28151
```

**2. Create the database**
=======
# Database Setup

Create a database in MySQL:

>>>>>>> b87e2a182a7b2d94b8648084958a594291348a53
```sql
CREATE DATABASE ecommerce_db;
```

<<<<<<< HEAD
**3. Configure `src/main/resources/application.properties`**
=======
---

# application.properties

>>>>>>> b87e2a182a7b2d94b8648084958a594291348a53
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password

<<<<<<< HEAD
app.jwt.secret=your_256_bit_secret_key_at_least_32_chars
app.jwt.expiration-ms=86400000

stripe.api.key=sk_test_your_stripe_secret_key
```

**4. Build and Run**
```bash
mvn clean spring-boot:run
```

> ✅ The app automatically creates all tables and seeds sample data on first startup.

---

## 🔑 Default Seeded Accounts

| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `admin123` |
| User | `user` | `user123` |

---

## 📖 API Endpoints

### 🔓 Authentication (Public)

| Method | Endpoint | Body | Description |
|---|---|---|---|
| `POST` | `/auth/register` | `{ "username", "password", "role": "user"/"admin" }` | Register a new user |
| `POST` | `/auth/login` | `{ "username", "password" }` | Login and receive JWT token |

### 📦 Products

| Method | Endpoint | Auth | Description |
|---|---|---|---|
| `GET` | `/api/products` | Public | Get all products |
| `GET` | `/api/products/{id}` | Public | Get product by ID |
| `POST` | `/api/products` | Admin | Create a product |
| `PUT` | `/api/products/{id}` | Admin | Update a product |
| `DELETE` | `/api/products/{id}` | Admin | Delete a product |

### 🛒 Cart (User Auth Required)

| Method | Endpoint | Params | Description |
|---|---|---|---|
| `GET` | `/api/cart` | — | View current user's cart |
| `POST` | `/api/cart/add` | `?productId=1&quantity=2` | Add item to cart |
| `PUT` | `/api/cart/update` | `?cartItemId=1&quantity=3` | Update item quantity |
| `DELETE` | `/api/cart/remove/{cartItemId}` | — | Remove item from cart |

### 📋 Orders & Payments (User Auth Required)

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/orders/checkout` | Create order from current cart |
| `GET` | `/api/orders` | Get all orders of logged-in user |
| `POST` | `/api/orders/{orderId}/pay` | Create Stripe PaymentIntent & mark order PAID |

---

## 💳 Stripe Payment Flow

1. Checkout → `POST /api/orders/checkout` → Order created (`CREATED`)
2. Pay → `POST /api/orders/{orderId}/pay` → Returns Stripe `clientSecret`
3. Frontend confirms payment using `clientSecret` + Stripe.js
4. Order status → `PAID`

---

## 📄 Swagger / API Docs

| URL | Description |
|---|---|
| http://localhost:8080/swagger-ui/index.html | Interactive Swagger UI |
| http://localhost:8080/api-docs | Raw OpenAPI JSON |

---

## 🧪 Running Tests
=======
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

app.jwt.secret=your_secret_key
app.jwt.expiration-ms=86400000

stripe.api.key=your_stripe_secret_key
```

---

# Run the Project

```bash
mvn clean install
mvn spring-boot:run
```

After starting the application:

* Swagger UI: `http://localhost:8080/swagger-ui/index.html`
* OpenAPI Docs: `http://localhost:8080/api-docs`

---

# Default Users

These users are added automatically when the project starts for the first time.

| Role  | Username | Password |
| ----- | -------- | -------- |
| ADMIN | admin    | admin123 |
| USER  | user     | user123  |

---

# API Endpoints

## Authentication

| Method | Endpoint       | Description             |
| ------ | -------------- | ----------------------- |
| POST   | /auth/register | Register new user       |
| POST   | /auth/login    | Login and get JWT token |

Example Login Request:

```json
{
  "username": "user",
  "password": "user123"
}
```

---

## Product APIs

| Method | Endpoint           | Access     |
| ------ | ------------------ | ---------- |
| GET    | /api/products      | Public     |
| GET    | /api/products/{id} | Public     |
| POST   | /api/products      | Admin Only |
| PUT    | /api/products/{id} | Admin Only |
| DELETE | /api/products/{id} | Admin Only |

---

## Cart APIs

| Method | Endpoint                                 |
| ------ | ---------------------------------------- |
| GET    | /api/cart                                |
| POST   | /api/cart/add?productId=1&quantity=2     |
| PUT    | /api/cart/update?cartItemId=1&quantity=3 |
| DELETE | /api/cart/remove/{cartItemId}            |

These APIs require JWT token in the Authorization header:

```text
Authorization: Bearer your_token_here
```

---

## Order APIs

| Method | Endpoint                  |
| ------ | ------------------------- |
| POST   | /api/orders/checkout      |
| GET    | /api/orders               |
| POST   | /api/orders/{orderId}/pay |

---

# Stripe Payment Flow

1. Add products to cart
2. Call `/api/orders/checkout`
3. Order is created with status `CREATED`
4. Call `/api/orders/{orderId}/pay`
5. Stripe returns `clientSecret`
6. Frontend uses `clientSecret` to complete payment
7. Order status becomes `PAID`

---

# Running Tests
>>>>>>> b87e2a182a7b2d94b8648084958a594291348a53

```bash
mvn test
```

<<<<<<< HEAD
---

## 🔒 Security Summary

| Endpoint Pattern | Access |
|---|---|
| `/auth/**` | Public |
| `GET /api/products/**` | Public |
| `/swagger-ui/**`, `/api-docs/**` | Public |
| All other endpoints | Requires valid JWT Bearer token |
| `POST/PUT/DELETE /api/products/**` | Requires `ROLE_ADMIN` |

---

## 📄 License

Distributed under the **MIT License**.
=======
The project contains unit tests for:

* Auth Service
* Product Service
* Cart Service
* Order Service

---

# Security Rules

| Endpoint                     | Access       |
| ---------------------------- | ------------ |
| /auth/**                     | Public       |
| GET /api/products/**         | Public       |
| /swagger-ui/**               | Public       |
| /api-docs/**                 | Public       |
| Other APIs                   | JWT Required |
| POST/PUT/DELETE Product APIs | ADMIN Only   |

---

# Notes

* Passwords are stored using BCrypt encryption.
* JWT is used for stateless authentication.
* Product read APIs are public.
* Product create, update, and delete APIs can only be accessed by admin.
* Cart and order APIs are available only after login.
* Sample products are inserted automatically when the application starts.

---

# Future Improvements

* Add pagination and sorting for products
* Add image upload for products
* Add email notifications after order placed
* Add refresh token support
* Add Docker support
* Deploy project on AWS or Render

---

This project was created for learning Spring Boot, Spring Security, REST APIs, and payment integration.
>>>>>>> b87e2a182a7b2d94b8648084958a594291348a53
