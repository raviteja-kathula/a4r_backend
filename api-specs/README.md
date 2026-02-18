# API Specifications for Workflow 3 (API-First Development)

This directory contains OpenAPI 3.0 specifications for the Crest & Thread E-commerce Platform. These specifications are designed to test **Workflow 3: API-First Development** as defined in the SDLC_SPECIFICATION.md.

## Available API Specifications

### 1. Products API (`products-api.yaml`)
**Purpose:** Core product catalog functionality

**Endpoints:**
- `GET /products` - List products with filtering, sorting, and pagination
- `GET /products/{productId}` - Get product details
- `GET /products/featured` - Get featured products

**Use Case:** Test backend generation for product browsing, filtering by category/type/color/size/price, and sorting

---

### 2. Cart API (`cart-api.yaml`)
**Purpose:** Shopping cart management

**Endpoints:**
- `GET /cart` - Get user's shopping cart
- `POST /cart/items` - Add item to cart
- `PUT /cart/items/{itemId}` - Update cart item quantity
- `DELETE /cart/items/{itemId}` - Remove item from cart

**Use Case:** Test secured endpoints (JWT authentication), cart operations, and price calculations

**Authentication:** Requires Bearer token

---

### 3. Checkout & Orders API (`checkout-orders-api.yaml`)
**Purpose:** Order placement and management

**Endpoints:**
- `POST /checkout` - Create checkout session
- `GET /orders` - Get order history
- `POST /orders` - Place an order
- `GET /orders/{orderId}` - Get order details
- `GET /orders/{orderId}/track` - Track order shipment

**Use Case:** Test complex request/response schemas, address validation, and order workflows

**Authentication:** Requires Bearer token (except tracking)

---

### 4. Auth & Users API (`auth-users-api.yaml`)
**Purpose:** User authentication and profile management

**Endpoints:**
- `POST /auth/register` - Register new user
- `POST /auth/login` - User login
- `GET /users/profile` - Get user profile
- `PUT /users/profile` - Update user profile
- `GET /users/wishlist` - Get wishlist
- `POST /users/wishlist` - Add to wishlist
- `DELETE /users/wishlist/{productId}` - Remove from wishlist
- `POST /newsletter/subscribe` - Subscribe to newsletter

**Use Case:** Test authentication flow, JWT token generation, and user data management

---

## How to Use with Workflow 3

### Step 1: Select an API Specification
Choose one of the YAML files based on what you want to test.

### Step 2: Provide to the AI
```
I want to use Workflow 3 (API-First) with api-specs/products-api.yaml.
Generate the backend implementation for the Products API.
Classification: BACKEND_ONLY (or FULL_STACK if you want frontend too)
```

### Step 3: Expected Generated Output

#### Backend (Always Generated):
- **Controllers** - REST endpoints matching the spec exactly
  - `ProductController.java`
  - Request/response validation
  
- **Services** - Business logic layer
  - `ProductService.java`
  - Filtering, sorting, pagination logic
  
- **Repositories** - Data access layer
  - `ProductRepository.java` (Spring Data JPA)
  
- **Entities** - Database models
  - `Product.java`
  - JPA annotations
  
- **DTOs** - Data transfer objects
  - `ProductDTO.java`, `ProductListResponseDTO.java`
  - MapStruct mappers
  
- **Exception Handling**
  - Custom exceptions matching error responses
  - Global exception handler
  
- **Tests** - JUnit 5 + Mockito
  - Controller tests
  - Service tests
  - Repository tests
  - ≥80% coverage

#### Frontend (If FULL_STACK Selected):
- **API Client** - Axios service
  - Type-safe API calls
  
- **TypeScript Interfaces** - Matching schemas
  - `Product.ts`, `ProductListResponse.ts`
  
- **React Hooks** - Custom hooks
  - `useProducts()`, `useProductDetails()`
  
- **Tests** - Jest + React Testing Library
  - Hook tests
  - Integration tests

---

## Workflow 3 Steps Reference

When using these API specifications, follow this workflow:

```
Step 0C: Feature Classification
  ↓
API Spec Analysis (Parse YAML)
  ↓
Step 4: Backend Code Generation
  ↓
Step 5: Frontend Code Generation (if FULL_STACK)
  ↓
Steps 6-14: Deployment & Testing
```

---

## Testing Scenarios

### Scenario 1: Simple CRUD API
**File:** `products-api.yaml`  
**Classification:** BACKEND_ONLY  
**Focus:** Basic REST operations, filtering, pagination

### Scenario 2: Authenticated API
**File:** `cart-api.yaml` or `auth-users-api.yaml`  
**Classification:** BACKEND_ONLY  
**Focus:** JWT security, Spring Security configuration

### Scenario 3: Complex Workflows
**File:** `checkout-orders-api.yaml`  
**Classification:** FULL_STACK  
**Focus:** Multi-step processes, complex schemas, state management

### Scenario 4: Full E-commerce Stack
**All Files**  
**Classification:** FULL_STACK  
**Focus:** Complete microservices, frontend integration

---

## API Design Features

These specifications demonstrate best practices:

✅ **RESTful Design** - Proper HTTP methods, status codes  
✅ **Pagination** - Page/limit parameters for list endpoints  
✅ **Filtering** - Query parameters for search  
✅ **Sorting** - Multiple sort options  
✅ **Error Handling** - Consistent error response schema  
✅ **Security** - Bearer token authentication  
✅ **Validation** - Required fields, min/max constraints  
✅ **Descriptive** - Clear summaries, descriptions, examples  
✅ **Typed** - Proper data types, formats, enums  

---

## Commerce Domain Context

All APIs are designed for **Crest & Thread**, an apparel e-commerce platform with:

- **Categories:** Women, Men, Accessories
- **Product Types:** Outerwear, Tops, Bags, Dresses, Bottoms, Scarves
- **Features:** Filtering, wishlist, cart, checkout, order tracking
- **User Roles:** Customer (authenticated and guest)

---

## Related Documentation

- Main specification: [`../SDLC_SPECIFICATION.md`](../SDLC_SPECIFICATION.md)
- User stories: [`../USER_STORIES.md`](../USER_STORIES.md)
- Backend standards: [`../_specs/backend_code_standards.md`](../_specs/backend_code_standards.md)
- Frontend standards: [`../_specs/frontend_react_code_standards.md`](../_specs/frontend_react_code_standards.md)

---

## Tools for Working with OpenAPI

- **Swagger Editor:** https://editor.swagger.io/ (validate YAML)
- **Swagger UI:** Visualize and test APIs
- **Postman:** Import OpenAPI specs for testing
- **OpenAPI Generator:** Generate client/server code

---

*Generated for testing Workflow 3 (API-First Development) in the SDLC-AI automation platform.*