# Let's Play - Backend API

A Spring Boot-based REST API for the Let's Play application, providing user management and product catalog functionality with MongoDB integration.

## Features

- **User Management**: Complete user registration and authentication system
- **Product Catalog**: RESTful API for product management
- **MongoDB Integration**: Modern NoSQL database with Spring Data MongoDB
- **RESTful API**: Clean, well-structured REST endpoints
- **Data Validation**: Comprehensive input validation and error handling
- **Layered Architecture**: Clean separation of concerns with Controller-Service-Repository pattern

## Tech Stack

- **Backend Framework**: Spring Boot 3.x
- **Database**: MongoDB with Spring Data MongoDB
- **Build Tool**: Maven
- **Code Generation**: Lombok
- **Testing**: Spring Boot Test

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MongoDB 4.4+ (running locally on port 27017)

## Quick Start

### 1. Clone the Repository
```bash
git clone https://learn.zone01kisumu.ke/git/viarony/lets-play.git
cd lets-play/backend
```
```bash
git clone https://github.com/VictorPaulArony/lets-play.git
cd lets-play/backend
```
### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Configure Environment
The application is configured to connect to MongoDB on localhost:27017 with database name `lets_play_db`. Modify `application.yaml` if needed:

```yaml
spring:
  mongodb:
    host: localhost
    port: 27017
    database: lets_play_db
```

### 4. Start the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Documentation

### User Management

#### Register a New User
```http
POST /api/users/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "password123",
  "role": "USER"
}
```

**Validation Rules:**
- Username: Required, non-empty
- Email: Required, valid email format
- Password: Required, minimum 6 characters
- Role: Optional (defaults to USER)

#### User Login
```http
POST /api/users/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "id": "user-id",
  "username": "john_doe",
  "email": "john@example.com",
  "role": "USER"
}
```

## Configuration

### Application Properties
The application is configured via `application.yaml`:

```yaml
server:
  port: 8080

spring:
  application:
    name: backend
  mongodb:
    host: localhost
    port: 27017
    database: lets_play_db
```

### Environment Variables
You can override configuration using environment variables:
- `SPRING_DATA_MONGODB_HOST`
- `SPRING_DATA_MONGODB_PORT`
- `SPRING_DATA_MONGODB_DATABASE`

## Testing

Run the test suite:
```bash
mvn test
```

## Building for Production

```bash
mvn clean package
```

This will create a JAR file in the `target/` directory that can be run with:
```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

## Security Considerations

- Password validation (minimum 6 characters)
- Email format validation
- Duplicate user prevention
- Input sanitization and validation
- Future plans for JWT token-based authentication

## Future Enhancements

- [ ] JWT token-based authentication
- [ ] Role-based access control
- [ ] Product management endpoints
- [ ] Advanced validation and error handling
- [ ] Comprehensive test suite
- [ ] API documentation with Swagger/OpenAPI
- [ ] Docker containerization

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Spring Boot Framework
- MongoDB
- Lombok
- Maven
