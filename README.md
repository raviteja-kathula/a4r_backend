# Crest & Thread - Backend API

[![Tests](https://img.shields.io/badge/Tests-14%2F14%20Passed-success)]()
[![Coverage](https://img.shields.io/badge/Coverage-86%25-brightgreen)]()
[![Java](https://img.shields.io/badge/Java-21-orange)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)]()

> RESTful backend API for Crest & Thread e-commerce platform built with Spring Boot 3 and PostgreSQL.

## 🚀 Quick Start

### Prerequisites
- Java 21
- PostgreSQL 18.1
- Maven 3.8+

### Setup
```bash
# Clone repository
git clone https://github.com/raviteja-kathula/a4r_backend.git
cd a4r_backend

# Configure database (application.yml)
# Update PostgreSQL credentials

# Build and run
mvn clean install
mvn spring-boot:run
```

Backend will start on: **http://localhost:8080/api**

## 📋 API Endpoints

### Products API

**GET** `/api/products/featured`
- Get featured products

**GET** `/api/products`
- Get all products (with filters, sort, pagination)
- Query params: `category`, `type`, `color`, `size`, `sort`, `page`, `limit`

### Newsletter API

**POST** `/api/newsletter/subscribe`
- Subscribe to newsletter
- Body: `{ "email": "user@example.com" }`

## 🏗️ Architecture

### Tech Stack
- **Framework**: Spring Boot 3.2.0
- **Language**: Java 21
- **Database**: PostgreSQL 18.1
- **ORM**: Spring Data JPA / Hibernate
- **Testing**: JUnit 5, Mockito
- **Coverage**: JaCoCo
- **Build**: Maven

### Project Structure
```
src/main/java/com/crestandthread/ecommerce/
├── entity/           Product, NewsletterSubscription
├── dto/              ProductDTO, ProductListResponse, ApiResponse
├── repository/       ProductRepository, NewsletterSubscriptionRepository
├── service/          ProductService, NewsletterService
├── controller/       ProductController, NewsletterController
├── exception/        GlobalExceptionHandler, DuplicateSubscriptionException
└── config/           WebConfig (CORS)

src/main/resources/
├── application.yml   Database & JPA configuration
└── data.sql          Sample product data (12 products)

src/test/java/        14 JUnit tests
```

## 🧪 Testing

### Run Tests
```bash
mvn clean test
```

### Generate Coverage Report
```bash
mvn clean test jacoco:report
```
Report available at: `target/site/jacoco/index.html`

### Test Results
- **Total Tests**: 14
- **Pass Rate**: 100%
- **Coverage**: 86%
- **Test Files**: 4 (Controllers + Services)

## 🗄️ Database Schema

### Products Table
- `id` (BIGINT, PK, Auto-increment)
- `title` (VARCHAR, NOT NULL)
- `category` (VARCHAR) - WOMEN, MEN, ACCESSORIES
- `type` (VARCHAR) - outerwear, tops, bags, dresses, bottoms, scarves
- `price` (NUMERIC)
- `image` (VARCHAR)
- `badge` (VARCHAR) - NEW, BESTSELLER, SALE
- `rating` (DOUBLE)
- `rating_count` (INTEGER)
- `stock_quantity` (INTEGER)
- `colors` (ElementCollection)
- `sizes` (ElementCollection)
- `created_at`, `updated_at` (TIMESTAMP)

### Newsletter Subscriptions Table
- `id` (BIGINT, PK, Auto-increment)
- `email` (VARCHAR, UNIQUE, NOT NULL)
- `subscribed_at` (TIMESTAMP)

## ⚙️ Configuration

### Database Connection
Edit `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/crest_thread_db
    username: postgres
    password: your_password
```

### CORS Configuration
CORS is enabled for `http://localhost:3000` (frontend). Update in `WebConfig.java` for production.

## 🔒 Security Features
- Input validation on all endpoints
- Unique email constraint for newsletter
- SQL injection prevention via JPA
- Exception handling with proper HTTP status codes

## 📊 Quality Metrics

| Metric | Value |
|--------|-------|
| Test Coverage | 86% |
| Tests Passed | 14/14 (100%) |
| Code Quality | Zero linter errors |
| Lombok Usage | All DTOs and Entities |

## 🎯 JIRA References

**API Stories**:
- API-001: Featured Products API
- API-002: Product Filtering API
- API-003: Product Sorting & Pagination
- API-004: Newsletter Subscription API

---

**AI Generated Code by Deloitte + Cursor**

© 2026 Crest & Thread
