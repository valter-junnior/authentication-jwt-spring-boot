<h1 align="center" style="font-weight: bold;">Spring Boot JWT Authentication API 💻</h1>

<p align="center">
 <a href="#tech">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
 <a href="#routes">API Endpoints</a> •
</p>

<p align="center">
    <b>RESTful API for user authentication using JWT, PostgreSQL with Docker Compose, Flyway migrations, Spring Security, and Clean Architecture.</b>
</p>

<h2 id="tech">💻 Technologies</h2>

- Java 24+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Flyway
- Docker & Docker Compose
- Clean Architecture

<h2 id="started">🚀 Getting Started</h2>

Instructions to run the project locally.

<h3>Prerequisites</h3>

- [Java 24+](https://adoptium.net/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Maven](https://maven.apache.org/)

<h3>Cloning</h3>

```bash
git clone https://github.com/your-username/spring-jwt-auth-api.git
```

<h3>Config .env variables</h3>

Create an `.env` file (or update `application.properties`) using the `.env.example` or `application-example.properties` as a reference.

```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/auth_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
JWT_SECRET=YourSuperSecretKey
```

<h3>Starting</h3>

1️⃣ Start PostgreSQL using Docker Compose:

```bash
docker-compose up -d
```

2️⃣ Run Flyway migrations (automatically triggered on app startup).

3️⃣ Start the application:

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

<h2 id="routes">📍 API Endpoints</h2>

| Route                        | Description                                                                 |
|------------------------------|-----------------------------------------------------------------------------|
| <kbd>POST /api/auth/register</kbd> | Register a new user                                                        |
| <kbd>POST /api/auth/login</kbd>    | Authenticate user and receive JWT token                                      |
| <kbd>GET /api/user/profile</kbd>   | Get user profile (requires JWT in Authorization header `Bearer <token>`)     |

<h3>POST /api/auth/register</h3>

**REQUEST**
```json
{
  "username": "newuser",
  "password": "securepassword"
}
```

**RESPONSE**
```json
{
  "message": "User registered successfully"
}
```

<h3>POST /api/auth/login</h3>

**REQUEST**
```json
{
  "username": "newuser",
  "password": "securepassword"
}
```

**RESPONSE**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
```

<h3>GET /api/user/profile</h3>

**HEADERS**
```
Authorization: Bearer <your_jwt_token>
```

**RESPONSE**
```json
{
  "id": 1,
  "username": "newuser",
  "roles": ["USER"]
}
```