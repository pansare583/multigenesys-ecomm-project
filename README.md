# 🛒 E-Commerce Backend — Production-Ready Spring Boot REST API

A professional, secure, and scalable e-commerce backend built with **Spring Boot 3**, **Spring Security (JWT)**, **PostgreSQL**, and **Stripe Payment Integration**.

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
| 📄 **Swagger UI** | Interactive API docs at `/swagger-ui.html` |
| 🧪 **Unit Tests** | JUnit 5 & Mockito tests for Auth, Product, Cart, and Order services |
| 🔄 **Auto Data Seeding** | Sample products and admin/user accounts loaded on startup |

---

## 🛠 Tech Stack

- **Java 17** · **Spring Boot 3.2.x** · **Spring Security** · **Spring Data JPA**
- **PostgreSQL** · **Lombok** · **MapStruct** · **JJWT**
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
```

---

## 🚦 Getting Started

### Prerequisites
- Java 17+
- PostgreSQL
- Maven

### Setup

**1. Configure `src/main/resources/application.properties`**
Update the following properties with your credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=postgres
spring.datasource.password=your_password

stripe.api.key=sk_test_your_key
```

**2. Build and Run**
```bash
mvn clean install
mvn spring-boot:run
```

---

## 🔑 Default Seeded Accounts

| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `admin123` |
| User | `user` | `user123` |

---

## 📖 API Endpoints

### 🔓 Authentication (Public)
- `POST /auth/register` - Create new account
- `POST /auth/login` - Get access token

### 📦 Products
- `GET /api/products` - List all products (Public)
- `POST /api/products` - Create product (Admin)

### 🛒 Cart (Authenticated)
- `GET /api/cart` - View cart
- `POST /api/cart/add` - Add item

### 📋 Orders & Payments (Authenticated)
- `POST /api/orders/checkout` - Create order
- `POST /api/orders/{orderId}/pay` - Get Stripe `clientSecret`

---

## 💳 Stripe Payment Flow

1. **Checkout**: Call `POST /api/orders/checkout` → Order created.
2. **Payment Intent**: Call `POST /api/orders/{orderId}/pay` → Returns `clientSecret`.
3. **Frontend Confirmation**: Use the `clientSecret` with Stripe Elements to complete the payment.
4. **Fulfillment**: Order status is updated to `PAID` (In production, use Stripe Webhooks).

---

## 📄 Swagger / API Docs
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI Docs**: http://localhost:8080/v3/api-docs
