# Task API

A RESTful task management API built with **Java 21**, **Spring Boot**, and **Spring Data JPA**.

## Features
- Full CRUD for tasks
- Layered architecture (Controller / Service / Repository)
- Input validation (Bean Validation) with clear `400` responses
- Consistent JSON error format for `400` and `404`
- Interactive API docs with Swagger UI
- Automated tests (JUnit 5)

## Tech stack
Java 21, Spring Boot, Spring Data JPA, H2, springdoc-openapi, JUnit 5, Maven

## Endpoints
| Method | URL | Description | Success |
|--------|-----|-------------|---------|
| GET | /api/tasks | List tasks | 200 |
| GET | /api/tasks/{id} | Get one task | 200 |
| POST | /api/tasks | Create a task | 201 |
| PUT | /api/tasks/{id} | Update a task | 200 |
| DELETE | /api/tasks/{id} | Delete a task | 204 |

## Error format

    {
      "timestamp": "2026-11-26T08:48:44Z",
      "status": 404,
      "error": "Not Found",
      "message": "Task 999 not found"
    }

## Run locally
Requires Java 21.

    ./mvnw spring-boot:run

- API: http://localhost:8085/api/tasks
- Swagger UI: http://localhost:8085/swagger-ui/index.html

## Run tests

    ./mvnw test

## Roadmap
- JWT authentication
- PostgreSQL + Flyway migrations
- Docker and CI with GitHub Actions
