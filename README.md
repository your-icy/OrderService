# Spring Boot Microservices Project

This project is a demonstration of a microservices architecture built using Spring Boot. The following services are included:

1. **Product API**
2. **Service Registry API**
3. **Config Server API**
4. **Order Service API**
5. **Payment Service API**
6. **Spring Security API**

## Table of Contents

- [Introduction](#introduction)
- [Architecture](#architecture)
- [Services](#services)
  - [Product API](#product-api)
  - [Service Registry API](#service-registry-api)
  - [Config Server API](#config-server-api)
  - [Order Service API](#order-service-api)
  - [Payment Service API](#payment-service-api)
  - [Spring Security API](#spring-security-api)
  - [API Gateway](#api-gateway)
- [Setup and Running the Project](#setup-and-running-the-project)
- [Technologies Used](#technologies-used)
- [License](#license)

## Introduction

This project illustrates a microservices architecture using Spring Boot. Each microservice is designed to handle a specific business function and can be developed, deployed, and scaled independently.

## Architecture

The architecture includes the following components:
- **Service Registry**: For service discovery and registration.
- **Config Server**: For centralized configuration management.
- **API Gateway**: For routing requests to the appropriate microservices (not detailed here).
- **Microservices**: Product, Order, Payment, with Spring Security for authentication and authorization.

## Services

### Product API

[Product API](https://github.com/your-icy/ProductService)

- **Description**: Manages product catalog.
- **Endpoints**:
  - `GET /products`: Retrieve all products.
  - `GET /products/{id}`: Retrieve a product by ID.
  - `POST /products`: Create a new product.
  - `PUT /products/{id}`: Update an existing product.
  - `DELETE /products/{id}`: Delete a product.

### Service Registry API

[Service Registry API](https://github.com/your-icy/ServiceRegistry)

- **Description**: Eureka server for service registration and discovery.
- **Endpoints**: Not applicable (Eureka dashboard available at `/eureka`).

### Config Server API

[Config Server API](https://github.com/your-icy/ConfigServer)

- **Description**: Centralized configuration management.
- **Endpoints**:
  - `GET /{application}/{profile}`: Retrieve configuration for a specific application and profile.

### Order Service API

[Order Service API](https://github.com/your-icy/OrderService)

- **Description**: Manages customer orders.
- **Endpoints**:
  - `GET /orders`: Retrieve all orders.
  - `GET /orders/{id}`: Retrieve an order by ID.
  - `POST /orders`: Create a new order.
  - `DELETE /orders/{id}`: Delete an order.

### Payment Service API

[Payment Service API](https://github.com/your-icy/PaymentService)

- **Description**: Handles payment processing.
- **Endpoints**:
  - `GET /payments`: Retrieve all payments.
  - `GET /payments/{id}`: Retrieve a payment by ID.
  - `POST /payments`: Process a new payment.
  - `PUT /payments/{id}`: Update an existing payment.
  - `DELETE /payments/{id}`: Cancel a payment.

### Spring Security API

- **Description**: Manages authentication and authorization.
- **Endpoints**:
  - `POST /auth/login`: Authenticate a user.
  - `POST /auth/register`: Register a new user.
  - `GET /auth/user`: Retrieve authenticated user details.


### API Gateway 

[APIGateway](https://github.com/your-icy/APIGateway)

- **Description**: Routes requests to the appropriate microservices and provides a single entry point for clients.
- **Endpoints**: Routes are configured to forward requests to the appropriate microservices.

#
## Setup and Running the Project

### Prerequisites

- JDK 11 or higher
- Maven 3.6.0 or higher
- Docker (optional for containerized deployment)
- PostgreSQL or any other RDBMS (for database services)

