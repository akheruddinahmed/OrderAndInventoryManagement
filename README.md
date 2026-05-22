# Order And Inventory Management

Spring Boot microservice for managing products and placing orders with stock tracking.

## Features
- Create products
- Place orders and decrement stock
- Validates insufficient stock

## Tech Stack
- Java 17
- Spring Boot 4.0.1 (Spring Data JPA, WebMVC)
- PostgreSQL

## Prerequisites
- Java 17 installed
- PostgreSQL running (default: `localhost:5433/orderandinventory`)
- Maven or the included Maven wrapper

## Configuration
Update `src/main/resources/application.properties` for your database credentials and URL:
- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

The service runs on port `8082` by default.

## Run
```bash
./mvnw spring-boot:run
```

## API Endpoints

### Create product
`POST /save`

Request body:
```json
{
  "name": "Keyboard",
  "price": 100,
  "stock": 50
}
```

### Place order
`POST /orders/place?id={productId}&qty={quantity}`

Returns the created order or a 400 response when stock is insufficient or product is unavailable.
