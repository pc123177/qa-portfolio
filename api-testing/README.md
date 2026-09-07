# API Testing — REST Assured + Java

REST API test suite targeting [reqres.in](https://reqres.in), a hosted public API purpose-built for testing.

## Stack

- [REST Assured](https://rest-assured.io) 5.5
- Java 17 + Maven
- TestNG 7.10 (parallel class execution)
- Allure 2.29 for reporting
- Lombok for model boilerplate

## Coverage

| Endpoint | Methods covered |
|----------|----------------|
| `GET /users` | pagination, structure validation |
| `GET /users/{id}` | happy path, 404 not found |
| `POST /users` | create with 201 + id assertion |
| `PUT /users/{id}` | update with `updatedAt` assertion |
| `DELETE /users/{id}` | 204 No Content |
| `POST /login` | valid credentials, missing password |
| `POST /register` | missing password error |

## Run locally

```bash
mvn test
```

## CI

Runs on every push/PR. Artifacts: Allure results + Surefire XML (30-day retention).

## Design decisions

- `ApiConfig` builds a single `RequestSpecification` with logging filters — every request and response is printed in CI logs without extra code per test.
- Models use Lombok `@Data` + Jackson `@JsonIgnoreProperties(ignoreUnknown = true)` so new API fields never break deserialization.
- TestNG suite runs test classes in parallel (`thread-count=2`) to keep CI time under 30s.
